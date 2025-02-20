import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhraseOccurences {
    public static Map<Character, Integer> compterCaracteres(String phrase) {
        Map<Character, Integer> occurences = new HashMap<>();
        for (char c : phrase.toCharArray()) {
            occurences.put(c, occurences.getOrDefault(c, 0) + 1);
        }
        return occurences;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String phrase = scan.nextLine();
        System.out.println(compterCaracteres(phrase));
    }
}
