import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fibonacci {

    public static List<Integer> genererFibonacci(int n) {
        List<Integer> fibonacci = new ArrayList<>();
        int a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            fibonacci.add(a);
            int temp = a + b;
            a = b;
            b = temp;
        }
        return fibonacci;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println("Les " + n + " premiers nombres de Fibonacci : " + genererFibonacci(n));
    }
}
