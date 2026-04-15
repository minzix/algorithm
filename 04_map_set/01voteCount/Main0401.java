import java.util.HashMap;
import java.util.Scanner;

public class Main0401 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        String str = sc.next();

        HashMap<Character, Integer> votes = new HashMap<>();
        for (char key: str.toCharArray()) {
            votes.put(key, votes.getOrDefault(key, 0) + 1);
        }
        int max = 0;
        char answer = ' ';

        for (char key: votes.keySet()) {
            if (max < votes.get(key)) {
                max = votes.get(key);
                answer = key;
            }
        }
        System.out.println(answer);
    }
}
