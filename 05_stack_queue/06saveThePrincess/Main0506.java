import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main0506 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 1 ~ N번의 왕자
        int K = sc.nextInt(); // Queue.size() 가 1일 때까지 K번째 왕자마다 Queue.poll() 하기
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            queue.offer(i + 1);
        }
        /*
        * 원형으로 계속 돌아가면서 순회해야 하므로 LinkedList 구조 (Queue)
        * 꺼내기: Queue.poll(), 추가: Queue.offer()
        */
        while (queue.size() != 1) {
            for (int j = 0; j < K - 1; j++) {
                queue.offer(queue.poll());
            }
            queue.poll();
        }
        System.out.println(queue.poll());
    }
}
