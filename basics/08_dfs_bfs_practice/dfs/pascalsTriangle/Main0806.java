import java.util.ArrayList;
import java.util.Scanner;

public class Main0806 {
    static int[] weight;
    static int firstRowCount, lastRowNum;
    static boolean found = false;
    public static int combination(int n, int r) { // 조합 nCr 계산
        if (r == 0 || n == r) return 1;
        return combination(n - 1, r - 1) + combination(n - 1, r);
    }
    public static void dfs(int level, ArrayList<Integer> firstRow) {
        if (found) return;
        if (level == firstRowCount) {
            int sum = 0;
            for (int i = 0; i < firstRowCount; i++) sum += firstRow.get(i) * weight[i];
            if (sum == lastRowNum) found = true;
        } else {
            for (int i = 1; i <= firstRowCount; i++) {
                if (!firstRow.contains(i)) {
                    firstRow.add(i);
                    dfs(level + 1, firstRow);
                    if (found) return;
                    firstRow.removeLast(); // 마지막에 넣은 값 제거
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        firstRowCount = sc.nextInt();
        lastRowNum = sc.nextInt();
        weight = new int[firstRowCount];
        ArrayList<Integer> firstRow = new ArrayList<>();
        for (int i = 0; i < firstRowCount; i++) weight[i] = combination(firstRowCount - 1, i);
        dfs(0, firstRow);
        for (int num : firstRow) System.out.print(num + " ");
    }
}
