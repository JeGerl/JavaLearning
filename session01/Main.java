
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;

public class Main{
    

    public static void main(String[] args) throws Exception {
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
        processAll(data, new CsvWriter("sensor_data.csv"));
        System.out.println();

        // ── InMemoryStore ─────────────────────────────────────────────────
        System.out.println("=== InMemoryStore ===");
        processAll(data, new InMemoryStore());

        System.out.println();


        List<Describable> things = new ArrayList<>();
        things.add(new Sensorreading(1, "S1", 19.3, 64.2));
        things.add(new Station("Nord", "Freiburg"));
        things.add(new Sensorreading(2, "S2", 22.1, 61.0));
        things.add(new Station("Süd", "Basel"));
        things.add(new Sensor("TEMP-01", "°C"));   // neue Klasse — for-each unverändert
        things.add(new Sensor("HUM-01",  "%rH"));

        for (Describable d : things) {
            System.out.println(d.describe());
        }

        System.out.println("═══ MultiHandler ═══");
        MultiHandler multi = new MultiHandler();
        multi.add(new ConsolePrinter());
        multi.add(new CsvWriter("sensor_data_multi.csv"));

        processAll(data, multi);   // eine Zeile — beide Handler laufen
        System.out.println("sensor_data_multi.csv geschrieben.");
        System.out.println();


        //___________________________________________Summary Printer____________

        processAll(data,new SummaryPrinter());

    }
    public static void processAll(List<Order> orders,
                                  PaymentProcessor processor) {
        for (Order o : orders) {
            boolean success = processor.process(o);
            if (!success) {
                System.err.println("Zahlung fehlgeschlagen: " + o);
            }
        }
    }
    public static void processAll(List<Sensorreading> readings, SensorDataHandler handler){
        for (Sensorreading r:readings){
            handler.handle(r);
        }
        handler.close();
    }
}