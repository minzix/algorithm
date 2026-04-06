import java.util.Scanner;

public class Main04 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        input.nextLine(); // nextInt 뒤 남은 \n 제거
        String[] reversedArr = new String[N];
        for (int i = 0; i < N; i++){
            String word = input.nextLine();
            reversedArr[i] = ""; // 기본값이 null이므로 빈문자열로 초기화
            for (int j = word.length()-1; j >= 0; j--){
                reversedArr[i] += word.charAt(j);
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.println(reversedArr[i]);
        }
    }
}
