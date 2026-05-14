import java.util.Scanner;

public class Solution0401 {
    static int N;
    public static int multi(int M) {
        if (M == 0) return 1;
        else return multi(M - 1) * N;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int test_case = 1; test_case <= 10; test_case++){
            int tc = sc.nextInt();
            N = sc.nextInt();
            int M = sc.nextInt();
            System.out.println("#" + tc + " " + multi(M));
        }
    }
}
