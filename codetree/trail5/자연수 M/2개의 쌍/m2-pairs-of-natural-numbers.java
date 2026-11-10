import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeMap<Long, Long> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            long x = sc.nextLong(); // 개수
            long y = sc.nextLong(); // 값
            map.put(y, x);
        }

        long max = 0;

        while (!map.isEmpty()) {
            long left = map.firstKey();
            long right = map.lastKey();

            // 값이 하나만 남은 경우 같은 값끼리 짝짓기
            if (left == right) {
                max = Math.max(max, left * 2);
                break;
            }

            long leftCnt = map.get(left);
            long rightCnt = map.get(right);
            long useCnt = Math.min(leftCnt, rightCnt); // 이번 반복에 양쪽에서 사용할 개수

            max = Math.max(max, left + right);

            if (leftCnt == useCnt) map.remove(left);
            else map.put(left, leftCnt - useCnt);

            if (rightCnt == useCnt) map.remove(right);
            else map.put(right, rightCnt - useCnt);
        }

        System.out.println(max);
    }
}