import java.util.Scanner;

class Solution0102 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int testCase = 1; testCase <= 10; testCase++) {
            /*
            * 양쪽 모두 거리 2 이상 확보될 때 (그림 기준 연두색) 조망권 확보한다고 하자. 조망권 확보 세대를 구하여라.
            * 2 ~ N - 2 까지 순회하면서, 조망권을 가지는지 구하기
            * arr[i+1], arr[i+2], arr[i-1], arr[i-2] 보다 arr[i] 에 더 큰 부분이 있다면 쟤네의 max를 구해서 arr[i] 에서 뺀 값을 viewCount 에 누적해서 출력
            */
            int N = sc.nextInt();
            int[] arr = new int[N]; // N개의 건물 높이
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            int viewCount = 0;
            for (int i = 2; i < N - 2; i++) {
                int max = Math.max(Math.max(arr[i+1], arr[i+2]), Math.max(arr[i-1], arr[i-2]));
                if (max < arr[i]) viewCount += (arr[i] - max);
            }
            System.out.println("#" + testCase + " " + viewCount);
        }
    }
}
