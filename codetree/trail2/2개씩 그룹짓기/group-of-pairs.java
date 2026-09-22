import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            nums[i] = sc.nextInt();
        }
        
        Arrays.sort(nums);
        int left = 0; 
        int right = nums.length - 1;
        int max = 0;
        // 2 3 5 5

        while (left < right) {
            max = Math.max(max, nums[left] + nums[right]);
            left++;
            right--;
        }

        System.out.println(max);
    }
}