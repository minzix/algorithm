import java.util.Scanner;

public class Solution0501 {
    static int LENGTH;
    static int[][] table;
    public static void main(String[] args) {
        // 테이블의 윗부분에 N극, 아래부분에 S극이 위치
        // 1 | 2 순으로 세로로 나오는 경계쌍이 몇쌍인지 구하기
        Scanner sc = new Scanner(System.in);
        int T = 10;
        for(int test_case = 1; test_case <= T; test_case++) {
            LENGTH = sc.nextInt();
            table = new int[LENGTH][LENGTH];
            for (int i = 0; i < LENGTH; i++) for (int j = 0; j < LENGTH; j++) table[i][j] = sc.nextInt();
            int count = 0;
            for (int i = 0; i < LENGTH; i++) {
                boolean isN = false;
                for (int j = 0; j < LENGTH; j++) {
                    int current = table[j][i];
                    if (current == 1) isN = true;
                    if (isN && current == 2) {
                        count++;
                        isN = false;
                    }
                }
            }
            System.out.println("#" + test_case + " " + count);
        }
    }
}
