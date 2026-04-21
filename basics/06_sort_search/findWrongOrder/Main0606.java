package findWrongOrder;

import java.util.Arrays;
import java.util.Scanner;

public class Main0606 {
    public static void main(String[] args) {
        // 잘못된 배열과 정렬된 배열 비교
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] height = new int[N]; // 잘못된 배열
        int[] heightSorted = new int[N]; // 정렬된 배열
        for (int i = 0; i < N; i++) {
            height[i] = sc.nextInt();
            heightSorted[i] = height[i];
        }
        Arrays.sort(heightSorted);
        for (int i = 0; i < N; i++) {
            if (height[i] != heightSorted[i]) System.out.print(i + 1 + " ");
        }
    }
}
