import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printStar(n);
    }

    private static void printStar(int count) {
        if (count == 0) return;
        for (int i = 0; i < count; i++) {
            System.out.print("* ");
        }
        System.out.println();
        
        printStar(count - 1);

        for (int i = 0; i < count; i++) {
            System.out.print("* ");
        }
        System.out.println();
    }
}