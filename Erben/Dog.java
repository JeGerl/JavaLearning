public class Dog extends Pet{
    private String breed;

    public Dog(String name, String breed) {
        this.breed = breed;
        super.name = name;
        super.sound = "Wuff";
    }

    @Override
    public void describe() {
        System.out.println("Hund:"+ super.name+" Rasse: "+this.breed);
    }
}