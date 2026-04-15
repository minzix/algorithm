package maxOnesInARowAfterKChanges;

import java.util.Scanner;

public class Main0306 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }
        // i 를 1씩 옮겨가면서 끝까지 순회해서 k를 다 쓸 때까지 0을 1로 바꾸고, 연속된 1 개수를 업데이트

    }
}
