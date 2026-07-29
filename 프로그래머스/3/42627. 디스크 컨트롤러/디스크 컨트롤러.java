import java.util.*;

class Job {
    int number;
    int requestTime;
    int workTime;

    Job(int number, int requestTime, int workTime) {
        this.number = number;
        this.requestTime = requestTime;
        this.workTime = workTime;
    }
}

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        PriorityQueue<Job> queue = new PriorityQueue<>(
            (a, b) -> {
                // 작업의 소요시간이 짧은 것, 작업의 요청 시각이 빠른 것, 작업의 번호가 작은 것 순으로 우선순위
                if (a.workTime != b.workTime) return a.workTime - b.workTime;
                else if (a.requestTime != b.requestTime) return a.requestTime - b.requestTime;
                else return a.number - b.number;
            }
        );
        
        // jobs[][] 를 작업의 요청시각 (jobs[i][0])이 빠른 순으로 정렬해서 queue에 넣어야 함
        // 그러나 바로 Arrays.sort 로 jobs 를 정렬하면 number를 정확히 채울 수 없음
        // Job[] 를 만들어서 Job 객체를 만들어 넣는 식으로 jobs를 복사한 후, 정렬조건을 걸어서 정렬함
        
        Job[] jobList = new Job[jobs.length];
        for (int i = 0; i < jobs.length; i++) jobList[i] = new Job(i, jobs[i][0], jobs[i][1]);
        Arrays.sort(jobList, (a, b) -> a.requestTime - b.requestTime);
        
        int currentTime = 0; // 시간이 흐를 때마다, requestTime이 현재 시각 이전인 Job들을 queue에 넣어야 함
        int turnaroundTime = 0;
        int idx = 0; // jobList 순회용 인덱스 
        
        while (!queue.isEmpty() || idx < jobs.length) { // Job을 queue에 다 들어가지 않았거나, queue가 비지 않았을 때 진행됨

            while (idx < jobs.length && currentTime >= jobList[idx].requestTime) { // idx 크기 검사 추가: 바깥 while문에서 검사하지만, 해당 while문을 돌면서 idx가 변화하므로 
                queue.add(jobList[idx]);
                idx++;
            }
            
            if (!queue.isEmpty()) {
                Job job = queue.poll();
                currentTime += job.workTime;
                turnaroundTime += (currentTime - job.requestTime);
            } else {
                if (idx < jobs.length) currentTime = jobList[idx].requestTime; // idx++ 후에 접근할 위험이 있으므로 검사 추가
            }
        }

        answer = turnaroundTime / jobs.length;
        return answer;
    }
}