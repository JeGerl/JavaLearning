import java.io.*;


public class CsvWriterBroken{
    public static void main(String[] args){
        try {
            Writer fw = new FileWriter("/broken.csv");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("1,S1,19.3,64.2");
            bw.newLine();
            bw.write("2,S1,22.1,61.0");
            bw.newLine();
            bw.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println("Fertig");
    }
}