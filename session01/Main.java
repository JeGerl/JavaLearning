public class main{
    

    public static void main(String[] args) {
        Describable d1 = new Sensorreading(1,"S1",19.4,64.3);
        Describable d2 = new Station("Nord", "Freiburg");

        System.out.println(d1.describe());
        System.out.println(d2.describe());
    }
}