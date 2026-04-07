import java.util.Scanner;

public class Main0202 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] arr = new int[n];
        int count = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
            // i번 학생이면 0 ~ i 사이의 학생들보다 전부 클 때만 count++ 가능
            if (max < arr[i]) count++;
            max = Math.max(max, arr[i]);
        }
        System.out.println(count);
    }
}
