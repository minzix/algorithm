import java.util.Arrays;
import java.util.Scanner;

public class Main0610 {
    public static void main(String[] args) {
        /*
        * left = 1
        * right = arr[N-1] - arr[0]
        * mid를 말들 사이의 최소 거리라고 했을 때, 말을 C마리 이상 배치할 수 있는 거리들 중 최댓값 구하기
        * */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 마구간 N개
        int C = sc.nextInt(); // 말 C마리
        int[] stall = new int[N];
        for (int i = 0; i < N; i++) {
            stall[i] = sc.nextInt();
        }
        Arrays.sort(stall);

        int left = 1, right = stall[N-1] - stall[0], answer = 0;
        while (left <= right) {
            int mid = (right + left) / 2; // 말들 사이의 거리
            // 0번에 첫번째 말을 배치한 상태
            int count = 1;
            int lastPos = stall[0];

            for (int i = 1; i < N; i++) {
                if (stall[i] - lastPos >= mid) { // 만약 직전 말과 다음 말 간의 간격이 mid보다 크다면,
                    count++; // 말 배치
                    lastPos = stall[i]; // 직전 말 정보 갱신
                }
            }
            if (count >= C) {
                answer = mid;
                left = mid + 1;
            }
            else right = mid - 1;
        }
        System.out.println(answer);
    }
}
