import java.util.Scanner;
import java.util.Stack;

public class Main0502 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (stack.isEmpty() && (c != '(') && (c!=')')) System.out.print(c);
            else if (c == '(') stack.add(c);
            else if (c == ')') stack.pop();
        }
    }
}
