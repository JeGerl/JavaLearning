
public class Sensorreading {
    public int seq;
    public String timestamp;
    public String stationID;
    public double temp;
    public double humid;

    public Sensorreading(int seq, String stationID, double temp, double humid){
        this.seq=seq;
        if(humid<0 ||humid>100){
            if(humid<0){
                this.humid =0;
            }else{
                this.humid=100;
            }
        }else{
            this.humid=humid;
        }
        if(stationID==null){
            throw new IllegalArgumentException("Station darf nicht null sein");
        }else{
            this.stationID=stationID;
        }
        

        if(temp< -273.15){
            this.temp= -273.15;
        }else{
            this.temp=temp;
        }
    }

    
public void print() {
    System.out.printf("%s | seq = %d | %.1f°C | %.1f%%%n",
        this.stationID, this.seq, this.temp, this.humid);


}
    public static void main(String[] args){
        Sensorreading r1= new Sensorreading(1, "S1", 19.3, 64.5);
        System.out.println("Temperatur 1: "+ r1.temp);
        Sensorreading r2 = new Sensorreading(2, "S1", -999, 64.5);
        System.out.println("Temp 2: "+ r2.temp);
        r2.print();
    }
    
}