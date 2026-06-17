import java.util.ArrayList;
import java.util.List;

public class MultiHandler implements SensorDataHandler {

    private List<SensorDataHandler> handlers = new ArrayList<>();

    /**
     * Fügt einen Handler zur Liste hinzu.
     * Alle zukünftigen handle()- und close()-Aufrufe werden an ihn delegiert.
     */
    public void add(SensorDataHandler handler) {
        handlers.add(handler);
    }

    @Override
    public void handle(Sensorreading reading) {
        for (SensorDataHandler h : handlers) {
            h.handle(reading);
        }
    }

    /**
     * Delegiert close() an alle enthaltenen Handler.
     * Jeder Handler ist dafür verantwortlich seinen eigenen Zustand zu schließen.
     */
    @Override
    public void close() {
        for (SensorDataHandler h : handlers) {
            h.close();
        }
    }
}