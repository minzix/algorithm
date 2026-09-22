import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = 100000;
        
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            if ((i + 1) % 2 != 0) {
                Arrays.sort(arr);
                System.out.print(arr[i / 2] + " ");
            }
        }
    }
}