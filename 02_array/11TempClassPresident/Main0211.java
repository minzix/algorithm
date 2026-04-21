import java.util.*;

public class Main0211 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][5];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int max = 0, student = 1;
        for (int s = 0; s < N; s++) { // 학생 한 명(s)에 대해서,
            Set<Integer> set = new HashSet<>();
            for (int g = 0; g < 5; g++) { // 학년이 1 ~ 5 일 때,
                for (int f = 0; f < N; f++) { // 각 학년에 있는 모든 학생들(f)을 순회하며 s랑 같은 반 (arr[s][g] == arr[f][g]) 인 횟수 구하기
                    if (s != f && arr[s][g] == arr[f][g]) set.add(f);
                }
            }
            // 모든 학년에 대해 순회한 후에 학생 한 명(s)에 대한 값 업데이트
            if (max < set.size()) {
                max = set.size();
                student = s + 1;
            }
        }
        System.out.println(student);
    }
}
