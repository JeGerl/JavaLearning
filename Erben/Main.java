public class Main {
    public static void main(String[] args) {
        Pet katze = new Cat("Steven",true);
        Cat katze2 = new Cat("Lucie", false);
        Dog hund = new Dog("Leya", "Labrador");

        hund.makeSound();
        hund.describe();
        katze.makeSound();
        katze2.makeSound();
        katze.describe();
        katze2.describe();
}}