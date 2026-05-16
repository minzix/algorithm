import java.util.ArrayList;
import java.util.Scanner;

public class Solution0801 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int test_case = 1; test_case <= 10; test_case++){
            int N = sc.nextInt();
            ArrayList<Integer> code = new ArrayList<>();
            for (int i = 0; i < N; i++) code.add(sc.nextInt());
            int queryNum = sc.nextInt();
            for (int q = 0; q < queryNum; q++) {
                String input = sc.next();
                if ("I".equals(input)) {
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    for (int i = 0; i < y; i++) code.add(x + i, sc.nextInt());
                }
            }
            System.out.print("#" + test_case);
            for (int i = 0; i < 10; i++) System.out.print(" " + code.get(i));
            System.out.println();
        }
    }
}
