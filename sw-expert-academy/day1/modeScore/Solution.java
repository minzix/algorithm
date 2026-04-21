import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int testCase = 1; testCase <= T; testCase++) {
            // 코드 작성
            sc.nextInt();
            Map<Integer, Integer> map = new HashMap<>(); // 숫자, 개수
            for (int i = 0; i < 1000; i++) {
                int num = sc.nextInt();
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            // value가 가장 큰 map의 key 출력
            int maxKey = 0, maxValue = 0;
            for (int key : map.keySet()) {
                if (maxValue < map.get(key) || (map.get(key) == maxValue && key > maxKey)) {
                    maxKey = key;
                    maxValue = map.get(key);
                }
            }
            System.out.println("#" + testCase + " " + maxKey);
        }
    }
}