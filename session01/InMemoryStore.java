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

    }
    
}