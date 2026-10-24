import java.util.*;

class Solution {
    static final int SIZE = 50;
    static int[] parent = new int[SIZE * SIZE];
    static String[] value = new String[SIZE * SIZE];   // 루트 위치에만 값 저장

    static int idx(String r, String c) {
        return (Integer.parseInt(r) - 1) * SIZE + (Integer.parseInt(c) - 1);
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);   // 경로 압축
    }

    // a = (r1,c1), b = (r2,c2)
    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return;
        if (value[a] == null) value[a] = value[b];  // (r1,c1) 값 우선, 없으면 (r2,c2) 값
        value[b] = null;                            // 루트가 아닌 쪽 값은 비움
        parent[b] = a;
    }

    public String[] solution(String[] commands) {
        for (int i = 0; i < SIZE * SIZE; i++) {
            parent[i] = i;
            value[i] = null;
        }
        List<String> printList = new ArrayList<>();

        for (String command : commands) {
            String[] ops = command.split(" ");

            if (ops[0].equals("UPDATE")) {
                if (ops.length == 4) {
                    value[find(idx(ops[1], ops[2]))] = ops[3];
                } else {
                    for (int i = 0; i < SIZE * SIZE; i++) {
                        if (ops[1].equals(value[i])) value[i] = ops[2];
                    }
                }
            } else if (ops[0].equals("MERGE")) {
                union(idx(ops[1], ops[2]), idx(ops[3], ops[4]));
            } else if (ops[0].equals("UNMERGE")) {
                int target = idx(ops[1], ops[2]);
                int root = find(target);
                String v = value[root];

                List<Integer> group = new ArrayList<>();
                for (int i = 0; i < SIZE * SIZE; i++) {
                    if (find(i) == root) group.add(i);   // 먼저 다 모으고
                }
                for (int i : group) {                    // 그다음 초기화
                    parent[i] = i;
                    value[i] = null;
                }
                value[target] = v;
            } else if (ops[0].equals("PRINT")) {
                String v = value[find(idx(ops[1], ops[2]))];
                printList.add(v == null ? "EMPTY" : v);
            }
        }

        String[] answer = new String[printList.size()];
        for (int i = 0; i < printList.size(); i++) answer[i] = printList.get(i);
        return answer;
    }
}