import java.util.function.Consumer;

/*
 * Nesse exemplo utilizamos um exemplo moderno do padrão de projeto Strategy
 * foi utilizado o enum para representar as formas de pagamento
 * e todas a lógica está separada por método, o que facilita a manutenção
 */
public class ModernStrategy {

    public static void main(String[] args) {
        String paymentMethod = "PIX"; // Declaramos a forma de pagamento
        PaymentType.valueOf(paymentMethod).pay(3.0); // chamamos a função de pagar e o valor;
    }

}

class PaymentMethods{
    // Verifique como cada função trabalha separadamente, facilitando a manutenção
    public static void creditCard(double amount){
        System.out.println("Validing credit card...");
        System.out.println("Paid R$: " + amount + " with credit card.");
    }

    public static void boleto(double amount){
        System.out.println("Generating barcode...");
        System.out.println("Paid R$: " + amount + " with boleto.");
    }

    public static void pix(double amount){
        System.out.println("Generating QR code...");
        System.out.println("Paid R$: " + amount + " with pix.");
    }
}

// Definimos um enum para representar as formas de pagamento
enum PaymentType{
    // Atribuimos a funcao de pagamento ao enum
    CREDIT_CARD (PaymentMethods::creditCard),
    BOLETO(PaymentMethods::boleto),
    PIX(PaymentMethods::pix);

    // Consumer é uma interface funcional. Recebe um valor do tipo T e não retorna nada
    // paymentStrategy recebe a funcao de pagamento
    private Consumer<Double> paymentStrategy;

    PaymentType(Consumer<Double> paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }

    public void pay(double amount){
        // Quando usa o accept invoca a função acima
        paymentStrategy.accept(amount); 
    }
}