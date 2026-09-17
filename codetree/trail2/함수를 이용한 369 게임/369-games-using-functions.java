import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        // Please write your code here.
        int count = 0;
        for (int num = A; num <= B; num++) {
            if (hasThree(num) || isDuplicateThree(num)) count++;
        }
        System.out.println(count);
    }

    private static boolean hasThree (int x) {
        String str = Integer.toString(x);
        for (char s : str.toCharArray()) {
            if (s == '3' || s == '6' || s == '9') return true;
        }
        return false;
    }

    private static boolean isDuplicateThree (int x) {
        if (x % 3 == 0) return true;
        else return false;
    }
}