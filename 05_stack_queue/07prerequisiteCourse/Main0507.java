import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main0507 {
    public static void main(String[] args) {
        // 필수과목에 해당하는 과목이라면, (queue.contains()), 선행과목 이수했는지 확인 (queue.peek() == c)
        Scanner sc = new Scanner(System.in);
        String pre = sc.nextLine();
        String classes = sc.nextLine();
        Queue<Character> queue = new LinkedList<>();
        for (char p : pre.toCharArray()) {
            queue.offer(p);
        }
        for (char c : classes.toCharArray()) {
            if (queue.contains(c)) {
                if (queue.poll() != c) {
                    System.out.println("NO");
                    return;
                }
            }
        }
        if (!queue.isEmpty()) {
            System.out.println("NO");
            return;
        }
        System.out.println("YES");
    }
}
