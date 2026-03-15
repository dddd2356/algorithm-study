package Simulation.Problem14719;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem14719 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] arr = new int[W];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int[] leftMax = new int[W];
        int[] rightMax = new int[W];

        int cur = 0;
        for (int i = 0; i < W; i++) {
            cur = Math.max(cur, arr[i]);
            leftMax[i] = cur;
        }

        cur = 0;
        for (int i = W - 1; i >= 0; i--) {
            cur = Math.max(cur, arr[i]);
            rightMax[i] = cur;
        }

        int water = 0;
        for (int i = 0; i < W; i++) {
            int min = Math.min(leftMax[i], rightMax[i]);
            if (min > arr[i])
                water += (min - arr[i]);
        }

        System.out.println(water);
    }
}
