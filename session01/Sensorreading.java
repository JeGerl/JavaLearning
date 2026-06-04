
public class Sensorreading implements Describable{
    private int seq;
    private String timestamp;
    private String stationID;
    private double temp;
    private double humid;

    public Sensorreading(int seq, String stationID, double temp, double humid) {
        this.seq = seq;
        
        if (stationID == null) {
            throw new IllegalArgumentException("Station darf nicht null sein");
        } else {
            this.stationID = stationID;
        }
        this.humid= validateHumid(humid);
        this.temp = validateTemp(temp);
    }

    public void print() {
        System.out.printf("%s | seq = %d | %.1f°C | %.1f%%%n",
                this.stationID, this.seq, this.temp, this.humid);

    }
    private double validateHumid(double h){
        if (h < 0 || h > 100) {
            if (h < 0) {
                System.err.println("UNgültige Luftfeuchtigkeit: "+ h);
                return 0.0;
            } else {
                System.err.println("UNgültige Luftfeuchtigkeit: "+ h);
                return 100.0;
            }
        } 
        return h;
    }
    private double validateTemp(double t){
        if(t<-273.15){
            System.err.println("Ungültige Temperatur: "+t);
            return -273.15;
        }
        return t;
    }



    public int getSeq(){
        return this.seq;
    }
    public String getTimestamp(){
        return this.timestamp;
    }
    public String getStationID(){
        return this.stationID;
    }
    public double getTemp(){
        return this.temp;
    }
    public void setTemp(double t){
        this.temp= validateTemp(t);
    }
    public double getHumid(){
        return this.humid;
    }
    public void setHumid(double h){
        this.humid = validateHumid(h);
    }
   
    @Override
    public String describe(){
        return "Reading " + seq+" : "+temp+"°C @ " + stationID;
    }



    public static void main(String[] args) {
        Sensorreading r1 = new Sensorreading(1, "S1", 19.3, 64.5);
        System.out.println("Temperatur 1: " + r1.temp);
        Sensorreading r2 = new Sensorreading(2, "S1", -999, 64.5);
        System.out.println("Temp 2: " + r2.temp);
        r2.print();
    }

}