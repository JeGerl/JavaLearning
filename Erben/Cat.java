public class Cat extends Pet{
    private boolean isIndoor;

    public Cat(String name, boolean isIndoor) {
        this.isIndoor=isIndoor;
        super.name = name;
        super.sound = "Miau";
    }

    @Override
    public void describe() {
        System.out.println("Katze:"+ super.name+(isIndoor?"Wohnungskatze":"Freigänger"));
    }
}