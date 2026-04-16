import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main0508 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // N명의 대기목록
        int M = sc.nextInt(); // M번째 환자의 진료순서 구하기
/*        int[] waitList = new int[N];
        ArrayList<Integer> sortList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int patient = sc.nextInt();
            waitList[i] = patient;
            sortList.add(patient);
        }
        sortList.sort(Collections.reverseOrder());
        System.out.println(sortList.indexOf(waitList[M])+1);*/
    }
}
