import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word1 = sc.next();
        String word2 = sc.next();
        
        if (isSame(word1, word2)) System.out.println("Yes");
        else System.out.println("No");
    }

    private static boolean isSame(String word1, String word2) {
        Map<Character, Integer> m1 = new HashMap<>();
        Map<Character, Integer> m2 = new HashMap<>();

        if (word1.length() != word2.length()) return false;

        for (char w1 : word1.toCharArray()) m1.put(w1, m1.getOrDefault(w1, 0) + 1);
        for (char w2 : word2.toCharArray()) m2.put(w2, m2.getOrDefault(w2, 0) + 1);

        if (!m1.keySet().equals(m2.keySet())) return false;

        for (char c : m1.keySet()) {
            if (!m1.get(c).equals(m2.get(c))) return false;
        }

        return true;
    }
}