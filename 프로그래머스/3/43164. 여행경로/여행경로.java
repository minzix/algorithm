import java.util.*;

class Solution {

    boolean[] visited;
    String[] answer;

    public String[] solution(String[][] tickets) {

        visited = new boolean[tickets.length];
        answer = new String[tickets.length + 1];

        answer[0] = "ICN";

        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) {
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        });

        dfs("ICN", 0, tickets);

        return answer;
    }

    boolean dfs(String current, int depth, String[][] tickets) {

        if (depth == tickets.length) {
            return true;
        }

        for (int i = 0; i < tickets.length; i++) {

            if (visited[i]) continue;

            if (!tickets[i][0].equals(current)) continue;

            visited[i] = true;
            answer[depth + 1] = tickets[i][1];

            if (dfs(tickets[i][1], depth + 1, tickets)) {
                return true;
            }

            visited[i] = false;
        }

        return false;
    }
}