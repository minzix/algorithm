import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0; 
        Queue<Integer> waiting = new LinkedList<>();
        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < truck_weights.length; i++) waiting.add(truck_weights[i]);        
        for (int i = 0; i < bridge_length; i++) bridge.add(0);  

        int currentWeight = 0;
        while (!waiting.isEmpty()) { // 마지막 트럭이 다리에 올라간 순간
            currentWeight -= bridge.poll();
            if (weight >= currentWeight + waiting.peek()) { // 다리에 올라갈 수 있음
                currentWeight += waiting.peek();
                bridge.add(waiting.poll());
            } else {
                bridge.add(0);
            }
            answer++;
        }
        return answer + bridge_length; 
    }
}