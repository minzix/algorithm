package BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class Main0608 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt(); // 찾는 수
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int left = 0, right = N - 1; // right = N - 1
        while (left <= right) { // = 들어가야 함
            int mid = (left + right) / 2;
            if (arr[mid] == M) {
                System.out.println(mid+1);
                return;
            }
            else if (arr[mid] < M) left = mid + 1;
            else right = mid - 1;
        }
    }
}
