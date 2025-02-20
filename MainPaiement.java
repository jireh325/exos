public class MainPaiement {
    public static void main(String[] args) {
        // Création des objets de paiement
        Paiement wave = new PaiementWave();
        Paiement orange = new PaiementOrange();
        Paiement paypal = new PaiementPaypal();

        // Test des paiements
        wave.effectuerPaiement(1000);
        orange.effectuerPaiement(2500);
        paypal.effectuerPaiement(5000);
    }
}
