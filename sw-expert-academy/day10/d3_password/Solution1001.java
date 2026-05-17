import java.util.ArrayList;
import java.util.Scanner;

public class Solution1001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 0~9로 이루어진 번호 문자열에서 같은 번호로 붙어있는 쌍들을 소거하고 남은 번호를 비밀번호로 만드는 것입니다.
        for(int test_case = 1; test_case <= 10; test_case++){
            int N = sc.nextInt(); // 문자열 길이
            String temp = sc.next();
            ArrayList<Character> code = new ArrayList<>();
            for (int i = 0; i < N; i++) code.add(temp.charAt(i));
            boolean flag = true;
            while (flag) {
                flag = false;
                for (int i = 0; i < code.size() - 1; i++) {
                    if (code.get(i) == code.get(i + 1)) {
                        code.remove(i);
                        code.remove(i);
                        flag = true;
                        if (i > 0) i--;
                    }
                }
            }
            System.out.print("#" + test_case + " ");
            for (char c : code) System.out.print(c);
            System.out.println();
        }
    }
}
