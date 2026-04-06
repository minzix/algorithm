import java.util.ArrayList;
import java.util.Scanner;

public class Main09 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        ArrayList<Character> arrList = new ArrayList<>();

        for (int i = 0; i < str.length(); i++){
            if (!(Character.isAlphabetic(str.charAt(i)))){
                arrList.add(str.charAt(i));
            }
        }
        int result = 0;
        for (int i = 0; i < arrList.size(); i++) {
            result = result * 10 + (arrList.get(i) - '0');
        }
        System.out.println(result);
    }
}
