import java.util.Scanner;

public class Solution0201 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = 10; // 사이트 오류로 10 하드코딩
        int SIZE = 100;
        for (int test_case = 1; test_case <= T; test_case++) {
            sc.nextInt(); // 사이트 오류로 추가
            int[][] arr = new int[SIZE][SIZE];
            for (int i = 0; i < SIZE; i ++) {
                for (int j = 0; j < SIZE; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            int maxRow = 0, maxCol = 0, down = 0, up = 0;
            for (int i = 0; i < SIZE; i ++) {
                int row = 0, col = 0;
                for (int j = 0; j < SIZE; j++) {
                    if (i == j) down += arr[i][j];
                    if (i + j == SIZE - 1) up += arr[i][j];
                    row += arr[i][j];
                    col += arr[j][i];
                }
                maxRow = Math.max(maxRow, row);
                maxCol = Math.max(maxCol, col);
            }
            int answer = Math.max(Math.max(maxRow, maxCol), Math.max(down, up));
            System.out.println("#" + test_case + " " + answer);
        }
    }
}
