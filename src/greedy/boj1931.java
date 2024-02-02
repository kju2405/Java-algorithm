package greedy;

import java.io.*;
import java.util.*;

public class boj1931 {
    static int N;
    static Schedule[] scheduleArr;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        scheduleArr = new Schedule[N];

        int start, end;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            scheduleArr[i] = new Schedule(start, end);
        }

        Arrays.sort(scheduleArr, new Comparator<Schedule>() {
            @Override
            public int compare(Schedule o1, Schedule o2) {
                if (o1.getEndTime() != o2.getEndTime()) {
                    return o1.getEndTime() - o2.getEndTime();
                }

                return o1.getStartTime() - o2.getStartTime();
            }
        });

        int time = 0;
        for (int i = 0; i < N; i++) {
            int startTime = scheduleArr[i].getStartTime();
            int endTime = scheduleArr[i].getEndTime();

            if (time <= startTime) {
                answer++;
                time = endTime;
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }

    private static class Schedule {
        private int startTime;
        private int endTime;

        Schedule(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        int getStartTime() {
            return startTime;
        }

        int getEndTime() {
            return endTime;
        }
    }
}
