import java.util.*;
import java.io.*;

class Solution {
	static Queue<Character> queue;
	static Set<Integer> set;
	static int N;
	
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			String numbers = br.readLine();
			
			queue = new LinkedList<>();
			set = new TreeSet<>((a, b) -> b - a);
			
			for (char c : numbers.toCharArray()) queue.add(c);
			
			for (int i = 0; i < N; i++) { // N번 반복 
				toDecimal();
				queue.add(queue.poll());
			}
			
			int idx = 1;
			for (int num : set) {
				if (idx == K) {
					System.out.println("#" + test_case + " " + num);
					break;
				}
				else idx++;
			}
		}
	}
	
	private static void toDecimal() { // 나열된 char들을 size 단위로 묶어서 Integer로 바꿔서 TreeSet에 삽입 
		int size = N / 4;
		StringBuilder sb = new StringBuilder();
		
		for (char c : queue) { 
			sb.append(c);
			if (sb.length() == size) {
				int number = Integer.parseInt(sb.toString(), 16);
				set.add(number);
				sb.setLength(0);		
			}
		}
	}
}
