import java.util.ArrayList;
import java.util.List;
import java.sql.Date;


public class MainTransaction {
    public static void main(String[] args) {
        List<Transaction> transactions = new ArrayList<>();
        
        // Exemple de création de transactions avec des dates et des montants
        transactions.add(new Transaction(100.50, Date.valueOf("2025-02-18")));
        transactions.add(new Transaction(50.75, Date.valueOf("2025-02-19")));
        transactions.add(new Transaction(200.00, Date.valueOf("2025-02-17")));

        // Trie les transactions en utilisant la méthode de tri
        List<Transaction> transactionsTriees = TriTransaction.trierTransactions(transactions);

        // Affiche les transactions triées
        for (Transaction transaction : transactionsTriees) {
            System.out.println(transaction);
        }
    }
}
