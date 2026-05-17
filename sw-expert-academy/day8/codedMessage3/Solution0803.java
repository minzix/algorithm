import java.util.ArrayList;
import java.util.Scanner;

public class Solution0803 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int test_case = 1; test_case <= 10; test_case++){
            int N = sc.nextInt(); // 암호문 길이
            ArrayList<Integer> code = new ArrayList<>(); // 암호문
            for (int i = 0; i < N; i++) code.add(sc.nextInt());
            int queryNum = sc.nextInt(); // query 개수
            for (int q = 0; q < queryNum; q++) {
                String input = sc.next();
                if ("I".equals(input)) {
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    for (int i = 0; i < y; i++) code.add(x + i, sc.nextInt());
                }
                if ("D".equals(input)) {
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    for (int i = 0; i < y; i++) code.remove(x);
                }
                if ("A".equals(input)) {
                    int y = sc.nextInt();
                    for (int i = 0; i < y; i++) code.add(sc.nextInt());
                }
            }
            System.out.print("#" + test_case);
            for (int i = 0; i < 10; i++) System.out.print(" " + code.get(i));
            System.out.println();
        }
    }
}
