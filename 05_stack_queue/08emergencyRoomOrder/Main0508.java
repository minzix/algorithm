import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Patient {
    int order;
    int danger;

    public Patient(int order, int danger) {
        this.order = order;
        this.danger = danger;
    }
}

public class Main0508 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // N명의 대기목록
        int M = sc.nextInt(); // M번째 환자의 진료순서 구하기

        // Patient 클래스를 순서대로 보관하는 큐
        Queue<Patient> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            queue.offer(new Patient(i, sc.nextInt()));
        }
        // for-each 문으로 해당 큐를 순회하면서 top 이 제일 위험도가 큰지 확인 - 제일 크면 pop (이 때, 만약 order가 M이면 count 출력), 아니면 pop한걸 바로 push
        int count = 0;
        while (!queue.isEmpty()) {
            int danger = queue.peek().danger;
            boolean isCritical = true;
            for (Patient patient : queue) {
                if (danger < patient.danger) {
                    queue.offer(queue.poll());
                    isCritical = false;
                    break;
                }
            }
            if (isCritical) {
                count++;
                if (queue.peek().order == M) {
                    System.out.println(count);
                    return;
                }
                queue.poll();
            }
        }
    }
}
