import java.util.Scanner;

public class Main0207 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        int[] arr = new int[N]; // 0: 오답, 1: 정답
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int count = 1; // 연속 count
        int total = 0;

        for (int i = 0; i < N; i++) {
            if (arr[i] == 1) {
                total += count;
                count ++;
            } else {
                count = 1;
            }
        }
        System.out.println(total);
    }
}
