import java.util.List;
import java.util.ArrayList;

public class Main{
    

    public static void main(String[] args) {
        Describable d1 = new Sensorreading(1,"S1",19.4,64.3);
        Describable d2 = new Station("Nord", "Freiburg");

        System.out.println(d1.describe());
        System.out.println(d2.describe());

        List<Sensorreading> data = new ArrayList<>();
        data.add(new Sensorreading(1, "S1", 19.3,   64.2));
        data.add(new Sensorreading(2, "S1", 22.1,   61.0));
        data.add(new Sensorreading(3, "S1", -500.0, 58.0));  // ungültige Temperatur
        data.add(new Sensorreading(4, "S1", 18.7,   150.0)); // ungültige Luftfeuchte
        data.add(null);

        // ── ConsolePrinter ────────────────────────────────────────────────
        System.out.println("=== ConsolePrinter ===");
        processAll(data, new ConsolePrinter());

        System.out.println();

        // ── InMemoryStore ─────────────────────────────────────────────────
        System.out.println("=== InMemoryStore ===");
        processAll(data, new InMemoryStore());

        System.out.println();


    }

    public static void processAll(List<Sensorreading> readings, SensorDataHandler handler){
        for (Sensorreading r:readings){
            handler.handle(r);
        }
        handler.close();
    }
}