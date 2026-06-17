import java.io.FileWriter;
import java.io.Writer;
import java.io.BufferedWriter;

public class Filetest {
    public static void main(String args[]) {
        try {
            Writer fw = new FileWriter("test.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("Zeile 1");
            bw.newLine();
            bw.write("Zeile 2");
            bw.newLine();
            bw.write("Zeile 3");
            bw.newLine();
            bw.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}