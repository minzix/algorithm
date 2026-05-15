import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution0701 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int test_case = 1; test_case <= 10; test_case++) {
            int tc = sc.nextInt();
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < 8; i++) queue.add(sc.nextInt());
            int num = 1;
            while (queue.peek() > num) {
                queue.add(queue.poll() - num);
                if (num == 5) num = 1;
                else num++;
            }
            queue.poll();
            queue.add(0);
            System.out.print("#" + tc + " ");
            for (int q : queue) System.out.print(q + " ");
            System.out.println("");
        }
    }
}
