import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in); // 문자열 \n 문자 형태의 입력
        String str = input.nextLine().toLowerCase();
        char character = input.nextLine().toLowerCase().charAt(0);
        int count = 0;

        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == character) {
                count ++;
            }
        }
        System.out.println(count);
    }
}