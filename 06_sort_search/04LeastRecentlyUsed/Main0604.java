import java.util.Scanner;

public class Main0604 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt(); // 캐시의 크기
        int N = sc.nextInt(); // 작업의 개수
        int[] jobArr = new int[N];
        int[] cacheArr = new int[S];
        for (int i = 0; i < N; i++) {
            jobArr[i] = sc.nextInt();
        }
        for (int s = 0; s < S; s++) {
            cacheArr[s] = jobArr[s];
        }
        for (int n = 0; n < N; n++) {
            // cache miss

            // cache hit
        }


    }
}
