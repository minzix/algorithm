import java.util.Scanner;

public class Main12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        String code = sc.nextLine();

        for (int i = 0; i < code.length() - 6; i += 7) {
            String temp = "";
            for (int j = 0; j < 7; j++){
                if (code.charAt(i + j) == '*'){
                    temp += "0";
                } else {
                    temp += "1";
                }
            }
            char ch = (char) Integer.parseInt(temp, 2);
            System.out.print(ch);
        }
    }
}
