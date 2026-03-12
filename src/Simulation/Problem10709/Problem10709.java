package Simulation.Problem10709;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem10709 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < H; i++) {
            String line = br.readLine();
            int lastCloud = -1;  // 가장 최근 구름의 열 위치

            for (int j = 0; j < W; j++) {
                if (line.charAt(j) == 'c') {
                    lastCloud = j;  // 구름 위치 갱신
                }

                if (lastCloud == -1) {
                    sb.append(-1);       // 왼쪽에 구름이 없음
                } else {
                    sb.append(j - lastCloud);  // 구름이 여기까지 오는 데 걸리는 시간
                }

                if (j < W - 1) sb.append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
