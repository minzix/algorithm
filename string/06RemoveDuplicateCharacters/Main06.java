import java.util.ArrayList;
import java.util.Scanner;

public class Main06 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();

        char[] charArr = str.toCharArray();
        ArrayList<Character> list = new ArrayList<>();

        for (int i = 0; i < charArr.length; i++){
            if (!list.contains(charArr[i])) {
                list.add(charArr[i]);
            }
        }
        for (char c : list) {
            System.out.print(c);
        }
    }
}
