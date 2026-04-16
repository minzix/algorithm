package countIronPieces;

import java.util.Scanner;
import java.util.Stack;

public class Main0505 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Stack<Character> stack = new Stack<>();
        int count = 0;
        /*
             ( 는 항상 stack에 push만
             ) 인 경우, 직전 char에 따라 경우의 수가 나뉨. (*직전 char 는 stack 기준으로 계산해서는 안됨 반드시 str.charAt(i-1) 등으로 접근할 것
             (1) 직전 = ( : 레이저      | count += stack.size()
             (2) 직전 = ) : 쇠막대기 끝  | count++
         */
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') stack.push(str.charAt(i));
            else {
                stack.pop();
                if (str.charAt(i-1) == '(') count += stack.size();
                else count++;
            }
        }
        System.out.println(count);
    }
}
