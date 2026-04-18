package DuplicateCheck;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main0605 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            int number = sc.nextInt();
            arr[i] = number;
            set.add(number);

        }
        if (arr.length == set.size()) System.out.println("U");
        else System.out.println("D");
    }
}
