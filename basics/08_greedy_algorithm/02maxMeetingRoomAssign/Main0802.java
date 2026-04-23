import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main0802 {
    static class Meeting {
        int start;
        int end;

        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Meeting> meetings = new ArrayList<>();
        Stack<Meeting> assignedMeetings = new Stack<>();
        for (int i = 0; i < N; i++) {
            meetings.add(new Meeting(sc.nextInt(), sc.nextInt()));
        }
        int count = 1;
        // end, start 오름차순 정렬
        meetings.sort((a, b) -> {
            if (a.end == b.end) return a.start - b.start;
            return a.end - b.end;
        });
        assignedMeetings.push(meetings.get(0));
        for (int i = 1; i < N; i++) {
            if (assignedMeetings.peek().end <= meetings.get(i).start) {
                assignedMeetings.push(meetings.get(i));
                count++;
            }
        }
        System.out.println(count);
    }
}
