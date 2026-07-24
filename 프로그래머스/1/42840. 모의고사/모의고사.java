import java.util.*;
// first[], second[], third[] 배열을 answer.length 만큼 생성하기 
// first[] 는 순회하면서 i값
// second[] 는 {2, 1, 2, 3, 2, 4, 2, 5}를 큐에 넣어두고 계속 add poll
// third[] 는 { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5}를 큐에 넣어두고 계속 add poll
// answer, first, second, third 배열 다같이 순회하며 각자 정답개수 누적합
// 정답개수 제일 많은 사람 출력
class Solution {
    public int[] solution(int[] answers) {
        int len = answers.length;
        
        int[] secondAnswerGenSet = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] thirdAnswerGenSet = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        Queue<Integer> second = new LinkedList<>();
        Queue<Integer> third = new LinkedList<>();
        
        for (int s : secondAnswerGenSet) second.add(s);
        for (int t : thirdAnswerGenSet) third.add(t);

        // int count[] = new int[3];
        Map<Integer, Integer> count = new HashMap<>(); 
        
        for (int i = 0; i < len; i++) {
            int ans = answers[i];
            int secondAns = second.poll();
            int thirdAns = third.poll();
            
            second.add(secondAns);
            third.add(thirdAns);
            
            if (ans == (i % 5 + 1)) count.put(1, count.getOrDefault(1, 0) + 1);
            if (ans == secondAns) count.put(2, count.getOrDefault(2, 0) + 1);
            if (ans == thirdAns) count.put(3, count.getOrDefault(3, 0) + 1);
        }
        
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(count.entrySet());

        list.sort((a, b) -> {
            if (!a.getValue().equals(b.getValue())) {
                return b.getValue() - a.getValue(); // value 내림차순
            }
            return a.getKey() - b.getKey();         // key 오름차순
        });

        List<Integer> answerList = new LinkedList<>();        
        int max = list.get(0).getValue();

        for(Map.Entry<Integer,Integer> entry : list){
            if(entry.getValue() == max)
                answerList.add(entry.getKey());
            else
                break;
        }
        
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answer.length; i++) answer[i] = answerList.get(i);

        return answer;
    }
}