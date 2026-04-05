import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in); // String
        String str = input.nextLine();
        String swapped = "";

        for (int i = 0; i < str.length(); i++) {
            if (Character.isUpperCase(str.charAt(i))) {
                swapped += Character.toLowerCase(str.charAt(i));
            } else {
                swapped += Character.toUpperCase(str.charAt(i));
            }
        }

        System.out.println(swapped);
    }
}