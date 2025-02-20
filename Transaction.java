
import java.sql.Date;

public class Transaction implements Comparable<Transaction> {

    private double montant;
    private Date date;

    public Transaction(double montant, Date date) {
        this.montant = montant;
        this.date = date;
    }

    public double getMontant() {
        return montant;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public int compareTo(Transaction autre) {
        return autre.date.compareTo(this.date);
    }

    @Override
    public String toString() {
        return "Transaction{" + "montant=" + montant + ", date=" + date + '}';
    }
}
