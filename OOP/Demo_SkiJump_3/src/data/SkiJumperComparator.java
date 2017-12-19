package data;

import java.util.Comparator;

/**
 *
 * @author student
 */
public class SkiJumperComparator implements Comparator<SkiJumper>{

    @Override
    public int compare(SkiJumper o1, SkiJumper o2) {
        if (o1.getScore() > o2.getScore()) {
            return 1;
        }else if(o1.getScore() < o2.getScore()){
            return -1;
        }
        return 0;
    }
    
}
