import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        char o = sc.next().charAt(0);
        int c = sc.nextInt();
        int answer = 0;
        
        if (o == '+') answer = add(a, c);
        else if (o == '-') answer = minus(a, c);
        else if (o == '*') answer = multi(a, c);
        else if (o == '/') answer = divide(a, c);
        else {
            System.out.println("False");
            return;
        }
        System.out.println(a + " " + o + " " + c + " = " + answer);
    }

    private static int add (int a, int c) {return (a + c);}
    private static int minus (int a, int c) {return (a - c);}
    private static int divide (int a, int c) {return (a / c);}
    private static int multi (int a, int c) {return (a * c);}

}