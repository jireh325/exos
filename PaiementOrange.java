public class PaiementOrange implements Paiement {

    public void effectuerPaiement(double montant) {
        System.out.println("Paiement de " + montant + " via Orange.");
    }
}
