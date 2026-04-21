import java.util.Scanner;

public class Main30 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 시험장 개수 = N개
        int[] arr = new int[N]; // i번 시험장의 응시인원 arr[i] 명
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int B = sc.nextInt(); // 총감독관 = B명 감시 가능, 시험장 당 1명만 존재
        int C = sc.nextInt(); // 부감독관 = C명 감시 가능, 제한 없음
        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer += 1;

            if (arr[i] >= B) { // 부감독관 필요
                arr[i] -= B;
                if (arr[i] % C == 0) answer += (arr[i] / C);
                else answer += (arr[i] / C + 1);
            }
        }
        System.out.println(answer);
    }
}
