import java.util.List;
import java.util.ArrayList;

public class InMemoryStore implements SensorDataHandler{
    private List<Sensorreading> readings = new ArrayList<>();

    @Override
    public void handle(Sensorreading reading){
        if (reading == null) {
            System.err.println("InMemoryStore: null-Reading empfangen — übersprungen");
            return;
        }
        readings.add(reading);
    }
    
    @Override
    public void close(){
        System.out.println("InMemory "+ readings.size()+" Readings gespeichert");
        if(readings.isEmpty()){
            System.out.println("Keine Daten");
            return;
        }
        double min = readings.get(0).getTemp();
        double max = readings.get(0).getTemp();

        for(Sensorreading r :readings){
            if(r.getTemp()<min) min=r.getTemp();
            if(r.getTemp()>max) max=r.getTemp();
        }
        System.out.println("Maximale Temperatur " +max+"°C");
        System.out.println("Minimale Temperatur "+min+"°C");
    }
    
}