import java.util.Scanner;
import java.util.Stack;

public class Main0504 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Stack<Integer> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) stack.add(c-'0');
            else {
                int right = stack.pop();
                int left = stack.pop();
                if (c == '+') stack.add(left + right);
                else if (c == '*') stack.add(left * right);
                else if (c == '-') stack.add(left - right);
                else stack.add(left / right);
            }
        }
        System.out.println(stack.pop());
    }
}
