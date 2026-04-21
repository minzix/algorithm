import java.util.Scanner;

public class Main0205 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        // 배열의 인덱스 (i) 는 소수인지 검사할 대상인 자연수로, 1 ~ N 까지만 사용
        // 배열의 값 (arr[i]) 은 소수인지 검사한 결과로 하여 일종의 Map처럼 활용
        int[] arr = new int[N+1]; // boolean 등 다른 타입의 배열이어도 무관함
        int count = 0;
        for (int i = 2; i <= N; i++) {
            if (arr[i] == 0) {
                count++;
                for (int j = i; j <=N; j += i) {
                    arr[j] = 1;
                }
            }
        }
        System.out.println(count);
    }
}
