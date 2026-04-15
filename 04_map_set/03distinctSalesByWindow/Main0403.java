import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main0403 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        System.out.print(map.size() + " ");
        for (int i = k; i < N; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            if (map.get(arr[i-k]) == 1) map.remove(arr[i-k]);
            else map.put(arr[i-k], map.get(arr[i-k]) - 1);
            System.out.print(map.size() + " ");
        }
    }
}
