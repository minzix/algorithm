import java.util.Arrays;
import java.util.Scanner;

public class Solution0502 {
    public static int stringToNum(String str) {
        if (str.equals("ZRO")) return 0;
        if (str.equals("ONE")) return 1;
        if (str.equals("TWO")) return 2;
        if (str.equals("THR")) return 3;
        if (str.equals("FOR")) return 4;
        if (str.equals("FIV")) return 5;
        if (str.equals("SIX")) return 6;
        if (str.equals("SVN")) return 7;
        if (str.equals("EGT")) return 8;
        if (str.equals("NIN")) return 9;
        return -1;
    }

    public static String numToString(int num) {
        if (num == 0) return "ZRO";
        if (num == 1) return "ONE";
        if (num == 2) return "TWO";
        if (num == 3) return "THR";
        if (num == 4) return "FOR";
        if (num == 5) return "FIV";
        if (num == 6) return "SIX";
        if (num == 7) return "SVN";
        if (num == 8) return "EGT";
        if (num == 9) return "NIN";
        return "";
    }

    public static void main(String[] args) {
        // "ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"
        // 1. 입력 받으면서 숫자 배열로 저장함 (문자열 -> 숫자 함수 하나 만들기)
        // 2. 숫자 배열 정렬
        // 3. 숫자 배열을 문자열로 출력 (숫자 -> 문자열 함수 하나 만들기)
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++){
            String tc = sc.next();
            int LENGTH = sc.nextInt();
            int[] arr = new int[LENGTH];
            for (int i = 0; i < LENGTH; i++) arr[i] = stringToNum(sc.next());
            Arrays.sort(arr);
            System.out.println(tc);
            for (int i = 0; i < LENGTH; i++) System.out.print(numToString(arr[i]) + " ");
        }
    }
}
