package DecisionAlgorithm;

import java.util.Scanner;

public class Main0609 {
    public static void main(String[] args) {
        /*
        * mid = DVD 길이 → mid에 따른 DVD 개수 구하기
        * 만약 개수가 M보다 작다면 당연히 더 작은 M은 성립하지 않고, 개수가 M보다 크다면 당연히 더 큰 M들도 전부 안됨
        * 개수 > M → left = mid + 1
        * 개수 < M → right = mid - 1
        * left = 배열 원소 중 최댓값
        * right = 배열 전체 합
        * */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt(); // DVD 개수
        int[] arr = new int[N];
        int sum = 0;
        int max = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
            if (arr[i] > max) max = arr[i];
        }
        int left = max, right = sum, answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            int count = 1; // DVD는 최소 1장부터 시작함
            int temp = 0;
            for (int i = 0; i < N; i++) {
                if (temp + arr[i] > mid) { // 현재 곡 arr[i]를 더했을 때 초과하는지를 검사해야하므로
                    count++;
                    temp = arr[i];
                } else {
                    temp += arr[i];
                }
            }
            if (count > M) left = mid + 1;
            else {
                answer = mid;
                right = mid - 1; // 최소값을 찾는 것이므로 같더라도 더 작은 값이 가능한지 왼쪽 탐색
            }
        }
        System.out.println(answer);
    }
}
