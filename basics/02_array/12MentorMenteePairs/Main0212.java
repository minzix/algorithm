import java.util.Scanner;

public class Main0212 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 반 학생 수 (j, 열)
        int M = sc.nextInt(); // 수학 테스트 횟수 (i, 행)
        int[][] arr = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int answer = 0;
        for (int mento = 0; mento < N; mento++) {
            for (int mentee = 0; mentee < N; mentee++) {
                if (mento == mentee) continue; // 자기 자신을 만나는 경우 제외

                int count = 0; // 멘토-멘티 한 쌍마다 count

                for (int exam = 0; exam < M; exam++) {
                    int mentoRank = 0, menteeRank = 0; // 시험마다 등수를 새로 구해야 함 (M번)

                    for (int rank = 0; rank < N; rank++) { //  해당 시험에서 각 학생의 등수 찾기 (N명 중 몇 등인지)
                        if (arr[exam][rank] == mento + 1) mentoRank = rank;
                        if (arr[exam][rank] == mentee + 1) menteeRank = rank;
                    }
                    if (mentoRank < menteeRank) count++; // 각 시험마다 비교
                }
                if (count == M) answer++; // 모든 시험에서 mento가 mentee보다 앞서면 정답 증가 (이번 멘토-멘티 쌍은 유효하다)
            }
        }
        System.out.println(answer);
    }
}