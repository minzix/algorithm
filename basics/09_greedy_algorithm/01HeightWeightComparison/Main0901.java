import java.util.ArrayList;
import java.util.Scanner;

public class Main0901 {
    static class Candidate {
        int height;
        int weight;

        Candidate (int height, int weight) {
            this.height = height;
            this.weight = weight;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Candidate> candidates = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            candidates.add(new Candidate(sc.nextInt(), sc.nextInt()));
        }
        int count = 0;
        for (int i = 0; i < N; i++) {
            boolean isSelect = true;
            for (int j = 0; j < N; j++) {
                if (candidates.get(i).height < candidates.get(j).height && candidates.get(i).weight < candidates.get(j).weight) isSelect = false;
            }
            if (isSelect) count++;
        }
        System.out.println(count);
    }
}
