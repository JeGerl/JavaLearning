import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvWriter implements SensorDataHandler {

    private BufferedWriter writer;

    /**
     * Öffnet die CSV-Datei zum Schreiben.
     * Überschreibt eine vorhandene Datei (kein append).
     *
     * @param filename  Pfad zur Ausgabedatei
     * @throws IOException wenn die Datei nicht geöffnet werden kann
     */
    public CsvWriter(String filename) throws IOException {
        this.writer = new BufferedWriter(new FileWriter(filename));
    }

    /**
     * Schreibt eine CSV-Zeile für das übergebene Reading.
     * Bei reading == null oder nach close(): stilles Ignorieren.
     */
    @Override
    public void handle(Sensorreading reading) {
        if (reading == null) return;
        if (writer == null) return;   // close() wurde bereits aufgerufen
        try {
            writer.write(reading.getSeq() + ","
                       + reading.getStationID() + ","
                       + reading.getTemp() + ","
                       + reading.getHumid());
            writer.newLine();          // plattformunabhängig: \r\n auf Windows, \n auf Unix
        } catch (IOException e) {
            System.err.println("CsvWriter: Fehler beim Schreiben — " + e.getMessage());
        }
    }

    /**
     * Leert den Puffer, schreibt alle Daten auf die Festplatte
     * und schließt die Datei.
     * Darf mehrfach aufgerufen werden.
     */
    @Override
    public void close() {
        if (writer == null) return;
        try {
            writer.close();            // flush() + Datei schließen
        } catch (IOException e) {
            System.err.println("CsvWriter: Fehler beim Schließen — " + e.getMessage());
        } finally {
            writer = null;             // Guard: verhindert Doppel-close und NPE in handle()
        }
    }
}