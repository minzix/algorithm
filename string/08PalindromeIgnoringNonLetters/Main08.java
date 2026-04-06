import java.util.Scanner;

public class Main08 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine().toLowerCase();

        int i = 0;
        int j = str.length() - 1;

        while (i < j) {
            if (!Character.isAlphabetic(str.charAt(i))) {
                i++;
                continue;
            }

            if (!Character.isAlphabetic(str.charAt(j))) {
                j--;
                continue;
            }

            if (str.charAt(i) != str.charAt(j)) {
                System.out.println("NO");
                return;
            }
            i++;
            j--;
        }

        System.out.println("YES");
    }
}