import java.util.Scanner;

public class Main0201 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
            if (i == 0) System.out.print(arr[i] + " ");
            else if (arr[i] > arr[i-1]) System.out.print(arr[i] + " ");
        }

    }
}
