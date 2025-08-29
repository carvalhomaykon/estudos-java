public class NoStrategy {

    /*
     * Esse é um exemplo na qual não utiliza o padrão de projeto Strategy, pois ele implementa a logica de pagamento diretamente na classe
     */
    
    public static void main(String[] args) {
        // Definimos a forma de pagamento
        int paymentMethod = 3; // 1 - Credit card; 2 - Boleto; 3 - Pix
        // E declaramos o valor
        double amount = 3.0;
        
        // Implementamos a lógica de pagamento utilizando if e else, o vai 
        // contra o padrão de projeto Strategy, pois caso seja necessário
        // realizar um manutenção no futuro, ele vai precisar ser alterado
        // diretamente na classe
        if (paymentMethod == 1) {
            System.out.println("Validing credit card...");
            System.out.println("Paid R$: " + amount + " with credit card.");
        } else if (paymentMethod == 2) {
            System.out.println("Generating barcode...");
            System.out.println("Paid R$: " + amount + " with boleto.");
        } else if (paymentMethod == 3) {
            System.out.println("Generating QR code...");
            System.out.println("Paid R$: " + amount + " with pix.");
        } else{
            throw new IllegalStateException("Payment method not supported");
        }
    }
}
