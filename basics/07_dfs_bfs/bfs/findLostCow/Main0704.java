import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main0704 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt(); // 현수의 위치
        int E = sc.nextInt(); // 송아지의 위치
        boolean visited[] = new boolean[10001];
        int[] move = {1, -1, 5}; // 현수는 +1, -1, +5 이동 가능
        int level = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(S);
        visited[S] = true;
        while (!queue.isEmpty()) {
            int size = queue.size(); // level의 queue 원소 개수
            for (int i = 0; i < size; i++) {
                int temp = queue.poll();
                if (temp == E) {
                    System.out.println(level);
                    return;
                } else {
                    for (int j = 0; j < 3; j++) {
                        int next = temp + move[j]; // 이동 위치

                        if (next >= 1 && next <= 10000 && !visited[next]) {
                            visited[next] = true;
                            queue.offer(next);
                        }
                    }
                }
            }
            level++;
        }
    }
}
