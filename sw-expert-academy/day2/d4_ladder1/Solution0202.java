import java.util.Scanner;

public class Solution0202 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int test_case = 1; test_case <= 10; test_case++) {
            int tc = sc.nextInt();
            int[][] data = new int[100][100];
            int X = 0;
            for (int y = 0; y < 100; y++) {
                for (int x = 0; x < 100; x++) {
                    data[y][x] = sc.nextInt();
                    if (y == 99 && data[y][x] == 2) X = x;
                }
            }
            int y = 99;
            while (y > 0) {
                if (X > 0 && data[y][X - 1] == 1) { // 왼쪽으로 갈 수 있으면 끝까지 이동
                    while (X > 0 && data[y][X - 1] == 1) X--;
                }
                else if (X < 99 && data[y][X + 1] == 1) { // 오른쪽으로 갈 수 있으면 끝까지 이동
                    while (X < 99 && data[y][X + 1] == 1) X++;
                }
                y--; // 좌우 이동 후 위로 한 칸 이동
            }
            System.out.println("#" + tc + " " + X);
        }
    }
}