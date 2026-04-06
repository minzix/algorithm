import java.util.Scanner;

public class Main07 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine().toLowerCase();
        int j = str.length() - 1;
        for (int i = 0; i < j; i++) {
            if (str.charAt(i) != str.charAt(j)) {
                System.out.println("NO");
                return;
            }
            j--;
        }
        System.out.println("YES");
    }
}
