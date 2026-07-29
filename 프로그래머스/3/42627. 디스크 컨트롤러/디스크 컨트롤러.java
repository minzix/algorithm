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

        int currentTime = 0;
        int turnaroundTime = 0;
        Arrays.sort(jobs, (a, b) -> (a[0] - b[0]));

        int i = 0; // 수정 : 아직 queue에 넣지 않은 다음 작업의 인덱스

        while (i < jobs.length || !queue.isEmpty()) { // 수정

            // 수정 : 현재 시간까지 요청된 작업을 모두 queue에 추가
            while (i < jobs.length && jobs[i][0] <= currentTime) {
                queue.add(new Job(i, jobs[i][0], jobs[i][1]));
                i++;
            }

            if (!queue.isEmpty()) {
                Job job = queue.poll();

                currentTime += job.workTime;  
                turnaroundTime += (currentTime - job.requestTime);

                System.out.println(currentTime - job.requestTime);
            } else {
                // 수정 : 아직 요청된 작업이 없으면 시간을 다음 작업의 요청 시각으로 이동
                currentTime = jobs[i][0];
            }
        }

        answer = turnaroundTime / jobs.length;
        return answer;
    }
}