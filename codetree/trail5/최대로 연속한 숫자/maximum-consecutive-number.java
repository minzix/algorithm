import java.util.*;

public class Main {
    static TreeSet<Integer> indexs;            // 지운 숫자들 (자동 정렬)
    static TreeMap<Integer, Integer> lengths;  // 구간 길이 -> 개수
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();

        indexs = new TreeSet<>();
        indexs.add(-1);          // 왼쪽 경계
        indexs.add(n + 1);       // 오른쪽 경계
        lengths = new TreeMap<>();
        lengths.put(n + 1, 1);   // 처음엔 0~N 전체 구간 하나

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int rm = sc.nextInt();
            sb.append(getLongestGap(rm)).append('\n');
        }
        System.out.print(sb);
    }

    private static int getLongestGap(int newIdx) {
        int l = indexs.lower(newIdx);    // newIdx보다 작은 지운 숫자 중 가장 큰 것
        int r = indexs.higher(newIdx);   // newIdx보다 큰 지운 숫자 중 가장 작은 것
        indexs.add(newIdx);

        removeLength(r - l - 1);         // 쪼개지는 기존 구간
        addLength(newIdx - l - 1);       // 왼쪽 조각
        addLength(r - newIdx - 1);       // 오른쪽 조각

        return lengths.lastKey();
    }

    private static void addLength(int len) {
        if (lengths.containsKey(len)) lengths.put(len, lengths.get(len) + 1);
        else lengths.put(len, 1);
    }

    private static void removeLength(int len) {
        int cnt = lengths.get(len);
        if (cnt == 1) lengths.remove(len);
        else lengths.put(len, cnt - 1);
    }
}