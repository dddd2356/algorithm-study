package Simulation.Problem13335;

import java.io.*;
import java.util.*;

public class Problem13335 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 트럭 수
        int w = Integer.parseInt(st.nextToken()); // 다리 길이
        int L = Integer.parseInt(st.nextToken()); // 다리의 최대 하중

        int[] trucks = new int[n];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trucks[i] = Integer.parseInt(st2.nextToken());
        }

        Queue<Integer> bridge = new LinkedList<>();
        // 처음엔 다리에 빈칸(0)을 w개 넣음
        for (int i = 0; i < w; i++) bridge.add(0);

        int time = 0;
        int idx = 0;      // 다음 대기 트럭 인덱스
        int sum = 0;      // 다리 위의 총 무게

        // 아직 대기 트럭이 있거나 다리에 트럭이 남아있으면 반복
        while (idx < n || sum > 0) {
            time++;
            int left = bridge.poll(); // 한 칸 이동 -> 앞칸 빠짐
            sum -= left;

            if (idx < n && sum + trucks[idx] <= L) {
                // 다음 트럭 올릴 수 있으면 올림
                bridge.add(trucks[idx]);
                sum += trucks[idx];
                idx++;
            } else {
                // 못 올리면 빈칸 추가
                bridge.add(0);
            }
        }

        System.out.println(time);
    }
}