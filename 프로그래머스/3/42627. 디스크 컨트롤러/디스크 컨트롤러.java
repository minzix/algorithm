import java.util.*;

class Job { // 작업의 번호, 작업의 요청 시각, 작업의 소요 시간
    int num;
    int arriveTime;
    int requiredTime;
    
    Job (int num, int arriveTime, int requiredTime) {
        this.num = num;
        this.arriveTime = arriveTime;
        this.requiredTime = requiredTime;
    }
}

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        // 소요시간이 짧은 것, 작업의 요청 시각이 빠른 것, 작업의 번호가 작은 것 순으로 우선순위가 높음
        PriorityQueue<Job> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a.requiredTime != b.requiredTime) return a.requiredTime - b.requiredTime;
                if (a.arriveTime != b.arriveTime) return a.arriveTime - b.arriveTime;
                if (a.num != b.num) return a.num - b.num;
                return 0;
            }
        );
        // int[num][] jobs = [작업이 요청되는 시점, 작업의 소요시간]
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        int currentTime = 0;
        int turnaroundTime = 0;
        int n = 0;
        
        while (n < jobs.length || !pq.isEmpty()) {
            if (pq.isEmpty() && jobs[n][0] > currentTime) {
                currentTime = jobs[n][0];
            }
            while (n < jobs.length && jobs[n][0] <= currentTime) {
                pq.add(new Job(n, jobs[n][0], jobs[n][1]));
                n++;
            }
            Job job = pq.poll();
            currentTime += job.requiredTime;
            turnaroundTime += (currentTime - job.arriveTime);
        }
        return turnaroundTime / jobs.length;
    }
}