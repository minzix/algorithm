import java.util.Scanner;

public class Main0603 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        // 삽입 정렬: 앞쪽은 이미 정렬되어 있다고 생각하고, 현재 숫자를 알맞은 위치에 끼워 넣는 방식
        for (int i = 1; i < N; i++) {
            int temp = arr[i];
            int j;

            for (j = i - 1; j >= 0; j--) {
                if (arr[j] > temp) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }

            arr[j + 1] = temp;
        }

        for (int x : arr) {
            System.out.print(x + " ");
        }

    }
}
