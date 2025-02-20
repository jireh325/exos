import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TriTransaction {

    public static List<Transaction> trierTransactions(List<Transaction> transactions) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<List<Transaction>> future = executor.submit(() -> {
            transactions.sort(Comparator.naturalOrder());
            return transactions;
        });

        try {
            return future.get();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        } finally {
            executor.shutdown();
        }
    }
    
}
