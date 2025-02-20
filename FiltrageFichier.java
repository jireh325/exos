import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FiltrageFichier {
    
    public static void filtrerFichier(String inputFile, String outputFile) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                if (ligne.startsWith("N")) {
                    bw.write(ligne);
                    bw.newLine();
                }
            }
        }
    }

    public static void main(String[] args) {
        String inputFile = "C:/Users/LENOVO/Downloads/rapport.txt";   // Fichier source
        String outputFile = "output.txt"; // Fichier filtré


        try {
            filtrerFichier(inputFile, outputFile);
            System.out.println("Filtrage terminé ! Vérifiez le fichier " + outputFile);
        } catch (IOException e) {
            System.out.println("Erreur lors du filtrage : " + e.getMessage());
        }

        // Affichage du fichier filtré
        try (BufferedReader reader = new BufferedReader(new FileReader(outputFile))) {
            String ligne;
            System.out.println("Contenu de " + outputFile + " :");
            while ((ligne = reader.readLine()) != null) {
                System.out.println(ligne);
            }
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier filtré : " + e.getMessage());
        }
    }
}
