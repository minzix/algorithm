import java.util.Scanner;
import java.util.Stack;

public class Main0501 {
    public static void main(String[] args) {
        // Stack은 LIFO이므로 대칭이어야 valid 한 괄호의 특성을 잘 반영함
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(') stack.push(c);
            else {
                if (stack.isEmpty()) {
                    System.out.println("NO");
                    return;
                }
                else stack.pop();
            }
        }
        if (stack.isEmpty()) System.out.println("YES");
        else System.out.println("NO");
    }
}
