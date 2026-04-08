import java.util.Scanner;

public class Main05 {
    public static void main(String[] args){
        // 쭉 순회하면서 알파벳이면 가장 뒤의 원소 중 알파벳인지 검사해서 알파벳인 애랑 SWAP
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        char[] arr = str.toCharArray(); // String -> char[]
        int j = arr.length - 1;
        for (int i = 0; i < j; i++) {
            // i번째가 알파벳 아님 -> 그냥 스킵
            // i번째가 알파벳 맞음 -> j번째가 알파벳일 때까지 찾기
            if (Character.isAlphabetic(arr[i])) {
                while (!Character.isAlphabetic(arr[j])) {
                    j--;
                }
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
        String result = new String(arr);
        System.out.println(result);
    }
}
