import java.util.HashMap;
import java.util.Scanner;

public class Main0402 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : str1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : str2.toCharArray()) {
            if (!map.containsKey(c)) {
                System.out.println("NO");
                return;
            }
            map.put(c, map.get(c) - 1);
        }
        for (char key : map.keySet()) {
            if (map.get(key) != 0) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
