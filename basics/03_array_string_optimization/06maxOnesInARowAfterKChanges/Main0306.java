import java.util.Scanner;

public class Main0306 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }
        /*
        * 초기값: left = 0; right = 0;
        * right++ 조건: arr[right + 1] == 1 || k > 0
        * left++ 조건: arr[right + 1] == 0 && k < 0 이면, (1) answer = Math.max(answer, right - left), (2) arr[left] == 0일 때까지 left++, (3) (2) arr[left] == 0이면 k++;
        */
        int left = 0, right = 0, answer = 0;
        while (left <= right && right < N - 1) {
            if (arr[right + 1] == 1 || k > 0) {
                right++;
                if(arr[right] == 0) k--;
            } else {
                answer = Math.max(answer, right - left);
                left++;
                if (arr[left] == 0) k++;
            }
        }
        System.out.println(answer);
    }
}
