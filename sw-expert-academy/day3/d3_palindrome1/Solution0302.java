import java.util.Scanner;

public class Solution0302 {
    public static boolean isPalindrome(String str) {
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int test_case = 1; test_case <= 10; test_case++){
            int answer = 0, SIZE = 8, length = sc.nextInt();
            sc.nextLine();
            char[][] arr = new char[SIZE][SIZE];

            for (int i = 0; i < SIZE; i++) {
                char[] temp = sc.nextLine().toCharArray();
                for (int j = 0; j < SIZE; j++) arr[i][j] = temp[j];
            }

            for (int fixedIdx = 0; fixedIdx < SIZE; fixedIdx++) {
                for (int startIdx = 0; startIdx <= SIZE - length; startIdx++) {
                    // 가로
                    String row = new String(arr[fixedIdx], startIdx, length); // new String(배열, 시작인덱스(offset), 길이(count))

                    // 세로
                    char[] temp = new char[length];
                    for (int offset = 0; offset < length; offset++) temp[offset] = arr[startIdx + offset][fixedIdx];
                    String col = new String(temp);

                    if (isPalindrome(row)) answer++;
                    if (isPalindrome(col)) answer++;
                }
            }
            System.out.println("#" + test_case + " " + answer);
        }
    }
}
