import java.util.Scanner;

public class Main0602 {
    public static void main(String[] args) {
        // 버블정렬 종료 조건: 한 세트 동안 한 번도 교환이 일어나지 않으면 정렬이 끝난 것이다.
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        /*
         * i는 각 세트 횟수: 한 세트 돌 때마다 각 세트에서 제일 작은 수가 맨 앞으로 가는 방식
         * 길이가 N일 때, N-1번만 돌아도 이미 남은 하나의 숫자의 순서는 결정되어있음
         */
        for (int i = 0; i < N - 1; i++) {
            int count = 0;
            /*
            * N - i ~ N 사이의 수들은 이미 제일 큰 수들로 정렬되어있으므로, 그 전까지만 비교해서 swap하면 됨
            * N까지 검사하면 j + 1 시 배열길이초과 오류 발생하므로 N - 1 필요
            */
            for (int j = 0; j < N - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    count++;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (count == 0) break;
        }
        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
