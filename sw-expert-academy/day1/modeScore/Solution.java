
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int testCase = 1; testCase <= T; testCase++) {
            // 코드 작성
            sc.nextInt();

            int maxKey = 0, maxValue = 0;
            int[] count = new int[101]; // 초기값은 다 0
            for (int i = 0; i < 1000; i++) {
                int idx = sc.nextInt();
                count[idx]++;
            }
            for (int i = 0; i <= 100; i++) {
                if (maxValue < count[i] || (count[i] == maxValue) && i > maxKey) {
                    maxKey = i;
                    maxValue = count[i];
                }
            }
            System.out.println("#" + testCase + " " + maxKey);
        }
    }
}