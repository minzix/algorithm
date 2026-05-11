import java.util.Scanner;

public class Solution0301 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int test_case = 1; test_case <= 10; test_case++) {
            int tc = sc.nextInt();
            sc.nextLine();
            String query = sc.nextLine();
            String sentence = sc.nextLine();
            int answer = 0;
            for (int i = 0; i <= sentence.length() - query.length(); i++) {
                if (sentence.substring(i, i + query.length()).equals(query)) answer++;
            }
            System.out.println("#" + tc + " " + answer);
        }
    }
}
