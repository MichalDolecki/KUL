package data;

/**
 *
 * @author student
 */
public class SkiJumper implements Comparable<SkiJumper>{
    private String name;
    private String country;
    private int score;

    public SkiJumper(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    public void addPoints(int points){
        score += points;
    }

    @Override
    public String toString() {
        return name + ", " + country + ", " + score + "pts";
    }

    @Override
    public int compareTo(SkiJumper o) {
        if (this.score > o.score) {
            return 1;
        }else if(this.score < o.score){
            return -1;
        }
        return 0;
    }
}
