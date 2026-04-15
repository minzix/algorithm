import java.util.HashMap;
import java.util.Scanner;

public class Main0404 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        String T = sc.nextLine(); // T문자열과 아나그램인 S문자열의 substring 개수 구하기
        int window = T.length();
        char[] arr = new char[S.length()];
        for (int i = 0; i < S.length(); i++){
            arr[i] = S.charAt(i);
        }
        HashMap<Character, Integer> Tmap = new HashMap<>();
        for (char c : T.toCharArray()) {
            Tmap.put(c, Tmap.getOrDefault(c, 0) + 1);
        }
        HashMap<Character, Integer> Smap = new HashMap<>();
        for (int i = 0; i < window; i++){
            Smap.put(arr[i], Smap.getOrDefault(arr[i], 0) + 1);
        }
        int count = 0;
        if (Tmap.equals(Smap)) count++;
        for (int i = window; i < S.length(); i++) {
            Smap.put(arr[i], Smap.getOrDefault(arr[i], 0) + 1);
            if (Smap.get(arr[i-window]) == 1) Smap.remove(arr[i-window]);
            else Smap.put(arr[i-window], Smap.get(arr[i-window]) - 1);
            if (Tmap.equals(Smap)) count++;
        }
        System.out.println(count);
    }
}
