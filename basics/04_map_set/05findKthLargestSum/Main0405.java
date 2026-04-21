import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class Main0405 {
    public static void main(String[] args) {
        // 1 ~ 100 범위의 수 N개 중 3개를 뽑아 합하는 모든 경우의 값을 구하고, 합을 정렬한 후 k번째로 큰 수를 출력
        // 같은 숫자가 여러 개 있을 수 있음 - TreeSet 사용
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = i + 1; j < N; j++){
                for (int m = j + 1; m < N; m++){
                    sum = arr[i] + arr[j] + arr[m];
                    set.add(sum);
                }
            }
        }
        int count = 0;
        for (int i : set) {
            count++;
            if (count == k) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }
}
