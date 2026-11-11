import java.util.*;

public class Main {
    static int[] moves, selected, postions;
    static int answer, n, m, k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 이동 
        m = sc.nextInt() - 1; // 도착점
        k = sc.nextInt(); // 말 개수 

        answer = 0;
        moves = new int[n];
        selected = new int[n]; // 말들의 위치
        postions = new int[k];
        for (int i = 0; i < n; i++) {
            moves[i] = sc.nextInt();
        }
        
        dfs(0);

        System.out.println(answer);
    }

    // dfs로 k 중 어떤 말을 움직일 건지를 selected 로 결정
    // 종료 전에 이 순서대로 움직였을 경우 시뮬
    // 순열 중복O dfs

    private static void dfs (int count) {
        if (count == n) {
            int finish = 0;
            for (int i = 0; i < n; i++) {
                postions[selected[i]] += moves[i];
            }
            for (int p : postions) {
                if (p >= m) finish++;
            }
            answer = Math.max(answer, finish);
            Arrays.fill(postions, 0);
            return;
        }

        for (int i = 0; i < k; i++) {
            selected[count] = i;
            dfs(count + 1);
        }
    }
}