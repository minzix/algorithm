import java.util.*;

class Solution {
  static int[] current;
  static int[] answer;
  static int[][] records;
  static int max;
  static boolean isAnswer;
  static int maxTotal;
  public static void main(String args[]) throws Exception {
    Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

    for(int test_case = 1; test_case <= T; test_case++) {
      int N = sc.nextInt();
      max = sc.nextInt();
      int M = sc.nextInt();

      current = new int[N];
      answer = new int[N];
      records = new int[M][3];
      isAnswer = false;
      maxTotal = -1;

      for (int i = 0; i < M; i++) {
        records[i][0] = sc.nextInt(); // start
        records[i][1] = sc.nextInt(); // end
        records[i][2] = sc.nextInt(); // count
      }

      dfs(0, 0);

      System.out.print("#" + test_case + " ");
      if (!isAnswer) System.out.print(-1);
      else for (int a : answer) System.out.print(a + " ");
      System.out.println();
    }
  }

  // 햄스터가 각 케이지에 들어가는 모든 경우의 수를 dfs로 구하고, 종료조건문에서 records를 전부 만족하는 경우만 누적
  private static void dfs(int idx, int total) {
    
    if (idx == current.length) {
      for (int[] record : records) {
        int startIdx = record[0] - 1;
        int endIdx = record[1];
        int count = record[2];

        int sum = 0;
        for (int i = startIdx; i < endIdx; i++) {
          sum += current[i];
        }
        if (count != sum) return;
      }

      if (total > maxTotal) {
        maxTotal = total;
        answer = current.clone();
        isAnswer = true;
      }
      return;
    }

    for (int num = 0; num <= max; num++) {
      current[idx] = num;
      dfs(idx + 1, total + num);
    }
  }
}
