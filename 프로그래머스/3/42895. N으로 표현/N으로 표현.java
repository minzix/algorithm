import java.util.*;

class Solution {
    public int solution(int N, int number) {

        List<Set<Integer>> dp = new ArrayList<>();

        for (int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }

        dp.get(1).add(N);

        if (N == number) {
            return 1;
        }

        for (int i = 2; i <= 8; i++) {

            // 5, 55, 555, 5555 ...
            int base = 0;
            int ten = 1;

            for (int k = 0; k < i; k++) {
                base += N * ten;
                ten *= 10;
            }

            dp.get(i).add(base);

            // j개 사용 + (i-j)개 사용
            for (int j = 1; j < i; j++) {

                Set<Integer> setA = dp.get(j);
                Set<Integer> setB = dp.get(i - j);

                for (int a : setA) {
                    for (int b : setB) {

                        dp.get(i).add(a + b);
                        dp.get(i).add(a - b);
                        dp.get(i).add(a * b);

                        if (b != 0) {
                            dp.get(i).add(a / b);
                        }

                        if (a != 0) {
                            dp.get(i).add(b / a);
                        }
                    }
                }
            }

            // i번 사용해서 number를 만들 수 있으면
            // i가 최소 사용 횟수
            if (dp.get(i).contains(number)) {
                return i;
            }
        }

        return -1;
    }
}