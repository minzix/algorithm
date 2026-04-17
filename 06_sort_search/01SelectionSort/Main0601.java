import java.util.Scanner;

public class Main0601 {
    public static void main(String[] args) {
        // 선택 정렬? 배열에서 가장 작은 값을 찾아 맨 앞자리와 바꾸는 정렬 방법
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            int idx = i;
            for (int j = i + 1; j < N; j++) {
                if (arr[j] < arr[idx]) idx = j;
            }
            if (arr[i] > arr[idx]) {
                int temp = arr[i];
                arr[i] = arr[idx];
                arr[idx] = temp;
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
