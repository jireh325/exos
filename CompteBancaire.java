import java.util.Scanner;

public class CompteBancaire {

    private double solde;

    public CompteBancaire(double soldeInitial) {
        this.solde = soldeInitial;
    }

    public void retirer(double montant) throws SoldeException {
        if (montant > solde) {
            throw new SoldeException("Solde insuffisant !");

        }else if(montant < 1){
            throw new SoldeException("entrez un nombre positif et superieur à 1");
        }

        solde -= montant;
        System.out.println("Retrait de " + montant + " effectué. Nouveau solde : " + solde);
    }

    public double getSolde() {
        return solde;
    }

    public static void main(String[] args) {

        CompteBancaire compte = new CompteBancaire(500);

        try {

            System.out.println("Solde initial : " + compte.getSolde());
            System.out.println("Entrez le montant à retirer");
            Scanner scan = new Scanner(System.in);
            double montant = scan.nextInt();
            compte.retirer(montant);

        } catch (SoldeException e) {
            System.out.println("Erreur : " + e.getMessage());
        }

        System.out.println("Solde final : " + compte.getSolde());
    }

}
