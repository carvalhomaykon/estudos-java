public class CommonStrategy {

    /*
     * Nesse exemplo utilizamos um exemplo comum do padrão de projeto Strategy
     * Dividimos a lógica de pagamento em classes separadas, o que facilita a manutenção
     * Definimos uma interface para criar o método pagamento
     */

    public static void main(String[] args) {
        var paymentMethodCode = 3;
        var amount = 3.0;

        // Foi criado um switch para escolher a forma de pagamento
        var paymentMethod = switch (paymentMethodCode){
            case 1 -> new CreditCard();
            case 2 -> new Boleto();
            case 3 -> new Pix();
            default -> throw new IllegalStateException("Payment method not supported");
        };

        var processador = new PaymentProcessor(paymentMethod); // Cria um processador de pagamento
        processador.pay(amount); // Chama a funcao de pagamento
    }

}

// Classe usada para processar o pagamento
class PaymentProcessor{
    private PaymentMethod paymentMethod;

    public PaymentProcessor (PaymentMethod paymentMethod){
        this.paymentMethod = paymentMethod;
    }

    // Funcao de pagamento
    public void pay(double amount){
        if (paymentMethod == null){
            throw new IllegalStateException("Payment method not supported.");
        }
        paymentMethod.pay(amount);
    }
}

// Interface de pagamento que será usada pelo processador
interface PaymentMethod{
    void pay(double amount);
}

// Classes de pagamento separada para facilitar a manutenção
class CreditCard implements PaymentMethod{
    @Override
    public void pay(double amount){
        System.out.println("Validing credit card...");
        System.out.println("Paid R$: " + amount + " with credit card.");
    }
}

class Boleto implements PaymentMethod{
    @Override
    public void pay(double amount){
        System.out.println("Generating barcode...");
        System.out.println("Paid R$: " + amount + " with boleto.");
    }
}

class Pix implements PaymentMethod{
    @Override
    public void pay(double amount){
        System.out.println("Generating QR code...");
        System.out.println("Paid R$: " + amount + " with pix.");
    }
}
