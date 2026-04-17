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
        for (int i = 1; i < N; i++) { // 맨 앞은 이미 정렬되어 있다고 생각하므로 i는 1부터 시작해서 순회
            int temp = arr[i]; // 삽입해야 하는 수
            int j = i - 1; // 정렬된 앞쪽은 0 ~ i - 1 범위임. 이 중 i - 1 경계를 표현

            while (j >= 0 && arr[j] > temp) { // 정렬된 앞쪽 배열 > 삽입해야 하는 수
                arr[j + 1] = arr[j];          // ▷ 정렬된 앞쪽 배열을 한 칸씩 뒤로 밀기 (삽입해야 하는 수 자리가 한 자리 비므로 거기까지 쭉 밀면 됨)
                j--;
            }
            // arr[j] <= temp 인 상태
            arr[j + 1] = temp; // 정렬된 앞쪽 배열 > 삽입해야 하는 수 인 위치의
        }

        for (int x : arr) {
            System.out.print(x + " ");
        }

    }
}
