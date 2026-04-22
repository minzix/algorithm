import java.util.Arrays;
import java.util.Scanner;

public class Solution0103 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int testCase = 1; testCase <= 10; testCase++) {
            // 가장 높은 곳의 상자를 가장 낮은 곳으로 옮기는 것 = dump
            int dump = sc.nextInt();
            int[] height = new int[100];
            for (int i = 0; i < 100; i++) {
                height[i] = sc.nextInt();
            }

            while (dump > 0) {
                Arrays.sort(height);
                if (height[99] - height[0] <= 1) break;
                height[0]++;
                height[99]--;
                dump--;
            }
            Arrays.sort(height);
            int diff = height[99] - height[0];
            System.out.println("#" + testCase + " " + diff);
        }
    }
}
