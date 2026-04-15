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
        sc.nextLine();
        Stack<Integer> basket = new Stack<>(); // 숫자를 넣기 전에 제일 위의 숫자를 확인한 후 같으면 pop하고, 다르면 그냥 넣음, pop 할 때마다 count ++
        int count = 0;
        for (int i = 0; i < M; i++) {
            int row = sc.nextInt() - 1;
//            System.out.println("row = " + row);
            for(int col = 0; col < N; col++) {
                System.out.println("col = " + col);
                if (board[col][row] != 0) {
                    if (basket.empty()) basket.add(board[col][row]);
                    else if (basket.peek() == board[col][row]) {
                        basket.pop();
                        count++;
                        System.out.println("count = " + count);
                    }
                    else basket.add(board[col][row]);
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
