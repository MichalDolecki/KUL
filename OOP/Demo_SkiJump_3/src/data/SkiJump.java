package data;

/**
 *
 * @author student
 */
public class SkiJump {
    private String name;
    private String country;
    private int Kpoint;
    private HillType type;

    public SkiJump(String name, String country, int Kpoint, HillType type) {
        this.name = name;
        this.country = country;
        this.Kpoint = Kpoint;
        this.type = type;
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

    public int getKpoint() {
        return Kpoint;
    }

    public void setKpoint(int Kpoint) {
        this.Kpoint = Kpoint;
    }

    public HillType getType() {
        return type;
    }

    public void setType(HillType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Ski Jump " + name;
    }
    
    
}
