import java.util.Scanner;

public class Main03 {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String sentence = input.nextLine();

        String[] splitedArr = sentence.split(" ");
        String longestWord = "";

        for (int i = 0; i < splitedArr.length; i++) {
            if (splitedArr[i].length() > longestWord.length()) {
                longestWord = splitedArr[i];
            }
        }
        System.out.println(longestWord);
    }
}
