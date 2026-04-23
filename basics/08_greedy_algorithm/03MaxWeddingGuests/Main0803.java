import java.util.Arrays;
import java.util.Scanner;

public class Main0803 {
    public static void main(String[] args) {
        // 친구들의 arrive, leave time 취합 - 하객은 arrive time에는 존재, leave time에는 존재하지 않음. (1분 일찍 도착, 1분 일찍 출발 한다고 가정하자)
        // 총 대여 시간 기간 (0 ~ 72)을 배열로 만들고, 인덱스를 시간, 값을 동시 존재하는 하객수로 고려
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[72];
        for (int i = 0; i < N; i++) {
            int arrive = sc.nextInt();
            int leave = sc.nextInt();
            for (int j = arrive; j < leave; j++) {
                arr[j]++;
            }
        }
        Arrays.sort(arr);
        System.out.println(arr[arr.length - 1]);
    }
}
