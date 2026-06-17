public class SummaryPrinter extends AbstractSensorHandler {
    private double minTemp;
    private double maxTemp;

    public SummaryPrinter(){
        this.minTemp=-400;
    
    }

    public void process(Sensorreading reading){
        double currentTemp = reading.getTemp();
        if(minTemp == (double)-400) {
            this.minTemp=currentTemp;
            this.maxTemp=currentTemp;
            return;
        }else{
            if (this.maxTemp<currentTemp) {
                this.maxTemp=currentTemp;
                return;
            }
            if(this.minTemp>currentTemp){
                this.minTemp=currentTemp;
                return;
            }
            return;
        }
    }
    @Override
    public void close(){
        System.out.println("Minmale Temperatur: "+ this.minTemp+"\n"+ "Maximale Temperatur: "+ this.maxTemp);
        super.close();
    }
    }