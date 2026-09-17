import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int count = 0;
        for (int num = a; num <= b; num++) {
            if (isPrime(num) && isSumEven(num)) count++;
        }
        System.out.println(count);
    }
    private static boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
    private static boolean isSumEven(int n) { // 각 자릿수 어케 구하지? 
        String str = Integer.toString(n);
        int sum = 0;
        for (char s : str.toCharArray()) {
            sum += (s - '0');
        }
        if (sum % 2 == 0) return true;
        return false;
    }
}