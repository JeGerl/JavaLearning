public class Sensor implements Describable {

    private String id;
    private String unit;

    public Sensor(String id, String unit) {
        this.id   = id != null ? id : "UNKNOWN";
        this.unit = unit != null ? unit : "";
    }

    public String getId()   { return id; }
    public String getUnit() { return unit; }

    @Override
    public String describe() {
        return "Sensor " + id + " misst in " + unit;
    }
}