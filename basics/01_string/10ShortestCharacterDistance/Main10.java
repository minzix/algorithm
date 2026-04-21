import java.util.ArrayList;
import java.util.Scanner;

public class Main10 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char t = sc.next().charAt(0);
        ArrayList<Integer> tArray = new ArrayList<>();

        // t의 인덱스들을 담은 배열 생성
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == t) {
                tArray.add(i);
            }
        }

        // 순회하면서 각 i 값에 e의 인덱스를 담은 배열 빼고, 정수로 변환한 후 min 구해
        for (int i = 0; i < s.length(); i++){
            int min = 100;
            for (int j = 0; j < tArray.size(); j++){
                int val = Math.abs(i-tArray.get(j));
                if (min > val) min = val;
            }
            System.out.print(min + " ");
        }
    }
}
