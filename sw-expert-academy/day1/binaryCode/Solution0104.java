import java.util.Scanner;

public class Solution0104 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int testCase = 1; testCase <= T; testCase++) {
            // 암호코드는 숫자 8개, 하나의 숫자는 각 7개의 비트로 암호화되어있음
            int N = sc.nextInt(); // 세로 크기 (입력 줄 수)
            int M = sc.nextInt();
            sc.nextLine();
            int NUM_LENGTH = 6;
            int NUM_COUNT = 8;
            String temp = "";
            for (int i = 0; i < N; i++) {
                String line = sc.nextLine();
                if (line.contains("1")) temp = line;
            }
            int endIdx = temp.lastIndexOf('1'); // 수정: 암호코드의 끝 위치 찾기
            int startIdx = endIdx - 55; // 수정: 암호코드 길이는 56칸
            temp = temp.substring(startIdx, endIdx + 1); // 수정: 실제 암호코드만 잘라내기

            int start = 0, end = start + NUM_LENGTH;
            int sum = 0;
            int oddSum = 0; // 홀수 자리의 합
            int evenSum = 0; // 짝수 자리의 합

            for (int j = 0; j < NUM_COUNT; j++) {
                String subTemp = temp.substring(start, end + 1);
                int code = switch (subTemp) {
                    case "0001101" -> 0;
                    case "0011001" -> 1;
                    case "0010011" -> 2;
                    case "0111101" -> 3;
                    case "0100011" -> 4;
                    case "0110001" -> 5;
                    case "0101111" -> 6;
                    case "0111011" -> 7;
                    case "0110111" -> 8;
                    case "0001011" -> 9;
                    default -> 0;
                };
                sum += code;
                if (j % 2 == 0) oddSum += code;
                else evenSum += code;
                start += NUM_LENGTH + 1;
                end = start + NUM_LENGTH;
            }
            // 올바른 암호 코드는 (홀수 자리의 합 x 3) + (짝수 자리의 합)이 10의 배수가 되어야 함
            // 올바른 암호코드일 경우, 암호코드에 포함된 숫자의 합을 출력
            if ((oddSum * 3 + evenSum) % 10 == 0) System.out.println("#" + testCase + " " + sum);
            // 잘못된 암호코드일 경우 대신 0을 출력
            else System.out.println("#" + testCase + " 0");

        }
    }
}
