import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main0802 {
    static int N, maxWeight;
    static int[] weights;
    public static void subset(int level, int sum, ArrayList<Integer> sumWeights) {
        if (sum > maxWeight) return;
        if (level == N) sumWeights.add(sum);
        else {
            subset(level + 1, sum + weights[level], sumWeights);
            subset(level + 1, sum, sumWeights);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        maxWeight = sc.nextInt();
        N = sc.nextInt();
        weights = new int[N];
        ArrayList<Integer> sumWeights = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            weights[i] = sc.nextInt();
        }
        subset(0, 0, sumWeights);
        System.out.println(Collections.max(sumWeights));
    }
}
