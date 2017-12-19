package app;

import data.Competition;
import data.HillType;
import data.SkiJump;
import data.SkiJumper;
import data.SkiJumperComparator;
import java.util.Arrays;

/**
 *
 * @author student
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SkiJumper jumper1 = new SkiJumper("Kamil Stoch", "PL");
        SkiJumper jumper2 = new SkiJumper("Adam Małysz", "PL");
        SkiJumper jumper3 = new SkiJumper("Piotr Żyła", "PL");
        SkiJumper jumper4 = new SkiJumper("Dawid Kubacki", "PL");

        SkiJumper jumpers[] = new SkiJumper[4];
        jumpers[0] = jumper1;
        jumpers[1] = jumper2;
        jumpers[2] = jumper3;
        jumpers[3] = jumper4;

        for (SkiJumper jumper : jumpers) {
            System.out.println(jumper);
        }

        jumpers[0].addPoints(80);
        jumpers[1].addPoints(180);
        jumpers[2].addPoints(60);
        jumpers[3].addPoints(250);

        System.out.println(">>>>>>>>>>>>>>>>>>>");
        for (SkiJumper jumper : jumpers) {
            System.out.println(jumper);
        }

        Arrays.sort(jumpers, new SkiJumperComparator());
        System.out.println(">>>>>>>>>>>>>>>>>>>");
        for (SkiJumper jumper : jumpers) {
            System.out.println(jumper);
        }

        SkiJump jump = new SkiJump("Wielka Krokiew", "PL", 125, HillType.LARGE);
        
        Competition c = new Competition(jump, jumpers);
        c.round1();
        c.round2();
        System.out.println(c);
        System.out.println(">>>>>>>>>>>>>>>>>>>");
        for (SkiJumper jumper : jumpers) {
            System.out.println(jumper);
        }
        
        c.round1();
        c.round2();
        System.out.println(">>>>>>>>>>>>>>>>>>>");
        System.out.println(c);
        System.out.println(">>>>>>>>>>>>>>>>>>>");
        for (SkiJumper jumper : jumpers) {
            System.out.println(jumper);
        }
    }

}
