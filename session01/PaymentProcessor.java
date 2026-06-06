public interface PaymentProcessor {
    boolean process(Order order);
}