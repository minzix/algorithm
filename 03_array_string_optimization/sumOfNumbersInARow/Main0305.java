package sumOfNumbersInARow;

import java.util.Scanner;

public class Main0305 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        // 합쳐서 N이 되는 수들은 모두 N / 2 + 1 이하이다
        // 1 ~ N / 2 + 1 의 수를 담은 배열 생성
        // Java에서 정수 나눗셈은 소수점 버리고 몫만 남긴다!
        int left = 1, sum = 0, count = 0;
        for(int right = 1; right <= (N/2+1); right++) {
            sum += right;
            while (sum > N) {
                sum -= left;
                left++;
            }
            if (sum == N) count++;
        }
        System.out.println(count);
    }
}
