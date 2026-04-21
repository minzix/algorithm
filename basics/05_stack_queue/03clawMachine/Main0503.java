import java.util.Scanner;
import java.util.Stack;

public class Main0503 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] board = new int[N][N]; // 인형 종류 100개, 같은 숫자는 같은 인형, 0은 빈칸
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        int M = sc.nextInt();
        Stack<Integer> basket = new Stack<>();
        int count = 0;
        for (int i = 0; i < M; i++) {
            int row = sc.nextInt() - 1;
            for(int col = 0; col < N; col++) {
                if (board[col][row] != 0) {
                    if (basket.empty()) basket.add(board[col][row]);
                    else if (basket.peek() == board[col][row]) {
                        basket.pop();
                        count += 2;
                    }
                    else basket.add(board[col][row]);
                    board[col][row] = 0;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
