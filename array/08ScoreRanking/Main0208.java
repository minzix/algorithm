import java.util.*;

public class Main0208 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        ArrayList<Integer> sortedList = new ArrayList<>();
        Map<Integer, Integer> rank = new HashMap<>();
        int[] score = new int[N];
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            sortedList.add(num);
            score[i] = num;
        }
        Collections.sort(sortedList, Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            if (!rank.containsKey(sortedList.get(i))) {
                rank.put(sortedList.get(i), i + 1);
            }
        }
        for (int s: score) {
            System.out.print(rank.get(s) + " ");
        }
    }
}