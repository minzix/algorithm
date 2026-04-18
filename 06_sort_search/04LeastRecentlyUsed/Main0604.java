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
        for (int j = 0; j < N; j++) {
            boolean isHit = false;
            for (int c = 0; c < S; c++) {
                if (jobArr[j] == cacheArr[c]) { // cache hit
                    int hit = cacheArr[c];
                    for (int i = c; i > 0; i--) cacheArr[i] = cacheArr[i - 1];
                    cacheArr[0] = hit;
                    isHit = true;
                    break;
                }
            }
            if (!isHit) {
                // cache miss
                for (int i = S - 1; i > 0; i--) cacheArr[i] = cacheArr[i - 1];
                cacheArr[0] = jobArr[j];
            }
        }
        for (int i : cacheArr) {
            System.out.print(i + " ");
        }
    }
}
