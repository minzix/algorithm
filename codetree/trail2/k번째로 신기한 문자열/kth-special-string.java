import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt(); 
        String t = sc.next();
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = sc.next();
        }

        // 문자열 t로 시작하는 단어 중, 사전순으로 정렬했을 때 k번째 문자열 출력
        Arrays.sort(words);

        for (String w : words) {
            if (w.startsWith(t)) k--;
            if (k == 0) {
                System.out.println(w);
                break;
            }
        }
    }
}