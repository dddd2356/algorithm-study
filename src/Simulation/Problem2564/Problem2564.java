package Simulation.Problem2564;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2564 {
    static int W, H;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(br.readLine());
        int[] shops = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            shops[i] = toPos(dir, x);
        }

        st = new StringTokenizer(br.readLine());
        int guardDir = Integer.parseInt(st.nextToken());
        int guardX = Integer.parseInt(st.nextToken());
        int guard = toPos(guardDir, guardX);

        int total = 0;
        for (int shop : shops) {
            int diff = Math.abs(guard - shop);
            total += Math.min(diff, 2 * (W + H) - diff);
        }
        System.out.println(total);
    }

    static int toPos(int dir, int x) {
        if (dir == 1) return x;               // 북
        if (dir == 2) return 2 * W + H - x;   // 남
        if (dir == 3) return 2 * W + 2 * H - x; // 서
        return W + x;                          // 동(4)
    }

}
