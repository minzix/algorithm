package findWrongOrder;

import java.util.Scanner;

public class Main0606 {
    public static void main(String[] args) {
        // 정상: height[i-1] < height[i] < height[i+1]
        // 철수: height[i] > height[i+1]
        // 철친: height[i-1] > height[i]
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] height = new int[N];
        int min = 100;
        int max = 0;
        for (int i = 0; i < N; i++) {
            height[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            if (i < N - 1 && height[i] > height[i+1]) {
                if (min > (i+1)) min = i+1;
            }
            if (i > 0 && height[i-1] > height[i]) {
                if (max < (i+1)) max = i+1;
            }
        }
        System.out.print(min + " " + max);
    }
}
