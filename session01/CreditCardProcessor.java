public class CreditCardProcessor implements PaymentProcessor {

    @Override
    public boolean process(Order order) {
        if (order == null) {
            System.err.println("CreditCardProcessor: null-Order empfangen — übersprungen");
            return false;
        }
        // In der Realität: Karte validieren, Betrag abbuchen, Transaktion loggen.
        // Hier: Simulation.
        System.out.println("Kreditkarte: " + order.getAmount()
            + " EUR abgebucht für " + order.getDescription()
            + " (Order " + order.getOrderId() + ")");
        return true;
    }

}