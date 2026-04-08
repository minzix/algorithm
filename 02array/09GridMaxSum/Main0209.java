import java.util.Scanner;

public class Main0209 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        int[][] arr = new int[N][N];
        int[] colSumArr = new int[N];
        int[] rowSumArr = new int[N];
        int diagonalUp = 0;
        int diagonalDown = 0;
        int maxCol = 0;
        int maxRow = 0;
        int max = 0;

        for (int i = 0; i < N; i++){
            int tempCol = 0;
            for (int j = 0; j < N; j++){
                arr[i][j] = sc.nextInt();
                tempCol += arr[i][j];
            }
            colSumArr[i] = tempCol;
            sc.nextLine();
        }
        // i 는 + 1씩, j는 +1씩 / i는 + 1씩 , j는 len-1 부터 -1씩
        int sideUp = 0;
        int sideDown = N - 1;
        for (int i = 0; i < N; i++){
            int tempRow = 0;
            diagonalUp += arr[i][sideUp];
            diagonalDown += arr[i][sideDown];
            sideUp++;
            sideDown--;
            for (int j = 0; j < N; j++){
                tempRow += arr[j][i];
            }
            rowSumArr[i] = tempRow;
        }
        for (int col : colSumArr) {
            if (maxCol < col) maxCol = col;
        }
        for (int row : rowSumArr) {
            if (maxRow < row) maxRow = row;
        }

        max = Math.max(Math.max(maxCol, maxRow), Math.max(diagonalUp, diagonalDown));
        System.out.println(max);
    }
}
