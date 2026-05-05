import java.util.ArrayList;
import java.util.Scanner;

class Problem {
    int score;
    int time;
    public Problem (int score, int time) {
        this.score = score;
        this.time = time;
    }
}
public class Main0803 {
    static int problemCount, timeLimit, maxScoreSum;
    public static void subset(int level, int sumTime, int sumScore, ArrayList<Problem> problems) {
        if (sumTime > timeLimit) return;
        if (level == problemCount) {
            if (maxScoreSum < sumScore) maxScoreSum = sumScore;
        } else {
            subset(level + 1,
                    sumTime + problems.get(level).time,
                    sumScore + problems.get(level).score,
                    problems
            );
            subset(level + 1, sumTime, sumScore, problems);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        problemCount = sc.nextInt();
        timeLimit = sc.nextInt();
        maxScoreSum = 0;
        ArrayList<Problem> problems = new ArrayList<>();
        for (int i = 0; i < problemCount; i++) {
            problems.add(new Problem(sc.nextInt(), sc.nextInt()));
        }
        subset(0, 0, 0, problems);
        System.out.println(maxScoreSum);
    }
}
