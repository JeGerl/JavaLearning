public class ConsolePrinter implements SensorDataHandler{

    private int count=0;

    @Override
    public void handle(Sensorreading reading){
        if(reading==null){
            System.err.println("ConsolePrinter: null-Reading empfangen — übersprungen");
            return;
        }
        reading.print();
        count++;
        return;

    }
    @Override
    public void close(){
        System.out.println("── ConsolePrinter: " + count + " Readings ausgegeben ──");
    }
}