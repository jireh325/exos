public class PaiementPaypal implements Paiement{

    public void effectuerPaiement(double montant) {
        System.out.println("Paiement de " + montant + " via Paypal.");
    }
}
