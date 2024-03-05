package greedy;

import java.io.*;
import java.util.*;

public class Boj11000 {
    static int N;
    static Time[] arr;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new Time[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            arr[i] = new Time(s, t);
        }

        Arrays.sort(arr, (t1, t2) -> {
            if (t1.s != t2.s) {
                return Integer.compare(t1.s, t2.s);
            } else {
                return Integer.compare(t1.t, t2.t);
            }
        });

        int[] endTime = new int[N];
        endTime[0] = arr[0].t;
        answer++;

        for (int i = 1; i < N; i++) {
            int s = arr[i].s;
            int t = arr[i].t;

            int num = answer;
            boolean flag = false;
            for (int j = 0; j < num; j++) {
                if (endTime[j] <= s) {
                    endTime[j] = t;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                endTime[answer] = t;
                answer++;
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }

    static class Time {
        int s;
        int t;

        Time(int s, int t) {
            this.s = s;
            this.t = t;
        }
    }
}

/*
아이디어

1. 수업의 시작시간을 우선으로 오름차순 후 끝나는 시간을 기준으로 오름차순 한다.
2. 끝나는 시간을 저장하는 배열을 생성
3. 반복문을 돌면서 끝나는 시간 배열에 수업의 시작시간(s)보다 낮은 숫자가 있으면 새로운 끝나는 시간으로 교체
4. 교체될 것이 없다면 answer++ 후 끝나는 시간 저장
 */