import java.util.Scanner;

public class Calculatrice {

    public int addition(int a, int b) {
        return a + b;
    }

    public int division(int a, int b) {
        if (b == 0) throw new ArithmeticException("Division par zéro !");
        return a / b;
    }

    public static void main(String[] args) {
        
        Calculatrice calc = new Calculatrice();
        Scanner scan = new Scanner(System.in);

        System.out.println("souhaitez-vous faire une addition ou une division ?");
        System.out.println("Saissez ***0*** pour l'addition ou ***1*** pour la division");
        int choix = scan.nextInt();

        switch (choix) {
            case 0:
                System.out.println("entrez le nombre a");
                int a = scan.nextInt();
        
                System.out.println("entrez le nombre b");
                int b = scan.nextInt();
        
                int somme = calc.addition(a, b);
                System.out.println(a + " + " + b + " = " + somme);
                
            break;

            case 1:
                System.out.println("entrez le nombre a");
                int x = scan.nextInt();
        
                System.out.println("entrez le nombre b");
                int y = scan.nextInt();
        
                int resultat = calc.division(x, y);
                System.out.println(x + " / " + y + " = " + resultat);
            break;
            
            default:
                throw new AssertionError();
        }

    }
}
