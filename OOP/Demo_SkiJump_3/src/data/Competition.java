package data;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 *
 * @author student
 */
public class Competition {

    private SkiJump jump;
    private SkiJumperInt[] jumpers;
    private int pK;
    private double pM;

    public Competition(SkiJump jump, SkiJumper[] jumpers) {
        this.jump = jump;
        switch (jump.getType()) {
            case NORMAL:
                pK = 60;
                pM = 2;
                break;
            case LARGE:
                pK = 60;
                pM = 1.8;
                break;
            case SKI_FLYING:
                pK = 120;
                pM = 1.2;
                break;
            default:
                throw new AssertionError();
        }
        this.jumpers = new SkiJumperInt[jumpers.length];
        for (int i = 0; i < jumpers.length; i++) {
            this.jumpers[i] = new SkiJumperInt(jumpers[i]);
        }
    }

    public void round1() {
        Random rand = new Random();
        double style[] = null;
        double length;
        for (int i = 0; i < jumpers.length; i++) {
            length = jump.getKpoint() + (rand.nextDouble() * 10 - 5);
            style = styleScores();
            jumpers[i].setLength1(length);
            jumpers[i].setNotes1(style);
            jumpers[i].calculateResult1();
        }
    }

    public void round2() {
        Random rand = new Random();
        double style[] = null;
        double length;
        Arrays.sort(jumpers, new JumperComparator1());
        int idx;
        for (int i = 0; i < 2; i++) {
            length = jump.getKpoint() + (rand.nextDouble() * 10 - 5);
            style = styleScores();
            idx = jumpers.length - 1 - i;
            jumpers[idx].setLength2(length);
            jumpers[idx].setNotes2(style);
            jumpers[idx].calculateResult2();
        }

        for (int i = 0; i < jumpers.length; i++) {
            jumpers[i].calculateResult();
        }

        Arrays.sort(jumpers, new JumperComparator());
        addPoints();
    }

    private double[] styleScores() {
        double[] worker = new double[5];
        Random rand = new Random();
        for (int i = 0; i < worker.length; i++) {
            worker[i] = rand.nextInt(21);
            if (worker[i] < 20 && rand.nextDouble() < 0.5) {
                worker[i] += 0.5;
            }
        }
        return worker;
    }
    
    private void addPoints(){
        for (int i = 0; i < jumpers.length; i++) {
            jumpers[i].getJumper().addPoints(Scores.scores[i]);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(jump).append("\n");
        for (SkiJumperInt jumper : jumpers) {
            sb.append(jumper).append("\n");
        }
        return sb.toString();
    }

    private class SkiJumperInt {

        private SkiJumper jumper;
        private double length1, length2;
        private double notes1[], notes2[];
        private double result1, result2, result;

        public SkiJumperInt(SkiJumper jumper) {
            this.jumper = jumper;
            notes1 = new double[5];
            notes2 = new double[5];
        }

        // TODO: parameters validation for setters
        public SkiJumper getJumper() {
            return jumper;
        }

        public void setJumper(SkiJumper jumper) {
            this.jumper = jumper;
        }

        public double getLength1() {
            return length1;
        }

        public void setLength1(double length1) {
            this.length1 = length1;
        }

        public double getLength2() {
            return length2;
        }

        public void setLength2(double length2) {
            this.length2 = length2;
        }

        public double[] getNotes1() {
            return notes1;
        }

        public void setNotes1(double[] notes1) {
            this.notes1 = notes1;
        }

        public double[] getNotes2() {
            return notes2;
        }

        public void setNotes2(double[] notes2) {
            this.notes2 = notes2;
        }

        public double getResult1() {
            return result1;
        }

        public void setResult1(double result1) {
            this.result1 = result1;
        }

        public double getResult2() {
            return result2;
        }

        public void setResult2(double result2) {
            this.result2 = result2;
        }

        public double getResult() {
            return result;
        }

        public void setResult(double result) {
            this.result = result;
        }

        public void calculateResult1() {
            double sum = 0.0;
            sum = pK + (length1 - jump.getKpoint()) * pM;
            sum += styleSum(notes1);

            result1 = sum;
        }

        public void calculateResult2() {
            double sum = 0.0;
            sum = pK + (length2 - jump.getKpoint()) * pM;
            sum += styleSum(notes2);

            result2 = sum;
        }

        public void calculateResult() {
            result = result1 + result2;
        }

        private double styleSum(double[] scores) {
            Arrays.sort(scores);
            double sum = 0.0;
            for (int i = 1; i < scores.length - 1; i++) {
                sum += scores[i];
            }
            return sum;
        }

        public String toString() {
            return jumper.toString() + ";" + length1 + ";" + result1 + ";" + length2 + ";" + result2 + ";" + result;
        }
    }

    private class JumperComparator1 implements Comparator<SkiJumperInt> {

        @Override
        public int compare(SkiJumperInt o1, SkiJumperInt o2) {
            if (o1.getResult1() > o2.getResult2()) {
                return 1;
            } else if (o1.getResult1() < o2.getResult2()) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    private class JumperComparator implements Comparator<SkiJumperInt> {

        @Override
        public int compare(SkiJumperInt o1, SkiJumperInt o2) {
            if (o1.getResult() > o2.getResult()) {
                return -1;
            } else if (o1.getResult() < o2.getResult()) {
                return 1;
            } else {
                return 0;
            }
        }

    }
}
