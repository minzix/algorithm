import java.util.Scanner;

public class Solution0303 {
    public static boolean isPalindromeRow(char[][] arr, int row, int col, int length) {
        int i = col, j = col + length - 1;
        while (i < j) {
            if (arr[row][i] != arr[row][j]) return false;
            i++;
            j--;
        }
        return true;
    }

    public static boolean isPalindromeCol(char[][] arr, int row, int col, int length) {
        int i = row, j = row + length - 1;
        while (i < j) {
            if (arr[i][col] != arr[j][col]) return false;
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int test_case = 1; test_case <= 10; test_case++) {
            int answer = 0, SIZE = 100;
            sc.nextInt();
            char[][] arr = new char[SIZE][SIZE];
            for (int i = 0; i < SIZE; i++) {
                arr[i] = sc.next().toCharArray();
            }
            outer: // 긴 길이부터 탐색
            for (int length = SIZE; length >= 1; length--) {
                for (int fixedIdx = 0; fixedIdx < SIZE; fixedIdx++) {
                    for (int startIdx = 0; startIdx <= SIZE - length; startIdx++) {
                        if (isPalindromeRow(arr, fixedIdx, startIdx, length)) {
                            // 가장 긴 회문 찾으면 정답 저장 후 종료
                            answer = length;
                            break outer;
                        }
                        if (isPalindromeCol(arr, startIdx, fixedIdx, length)) {
                            // 가장 긴 회문 찾으면 정답 저장 후 종료
                            answer = length;
                            break outer;
                        }
                    }
                }
            }
            System.out.println("#" + test_case + " " + answer);
        }
    }
}