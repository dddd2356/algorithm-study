package Simulation.Problem1063;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Problem1063 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                                                                                               StringTokenizer st = new StringTokenizer(br.readLine());

        // 좌표 변환: 'A'~'H' → 0~7, '1'~'8' → 0~7
        String kingPos = st.nextToken();
        String stonePos = st.nextToken();
        int n = Integer.parseInt(st.nextToken());

        int kx = kingPos.charAt(0) - 'A';
        int ky = kingPos.charAt(1) - '1';
        int sx = stonePos.charAt(0) - 'A';
        int sy = stonePos.charAt(1) - '1';

        // 방향: R L B T RT LT RB LB
        Map<String, int[]> dir = new HashMap<>();
        dir.put("R",  new int[]{ 1,  0});
        dir.put("L",  new int[]{-1,  0});
        dir.put("B",  new int[]{ 0, -1});
        dir.put("T",  new int[]{ 0,  1});
        dir.put("RT", new int[]{ 1,  1});
        dir.put("LT", new int[]{-1,  1});
        dir.put("RB", new int[]{ 1, -1});
        dir.put("LB", new int[]{-1, -1});

        for (int i = 0; i < n; i++) {
            int[] d = dir.get(br.readLine().trim());
            int nkx = kx + d[0];
            int nky = ky + d[1];

            // 킹이 범위 밖이면 무시
            if (nkx < 0 || nkx > 7 || nky < 0 || nky > 7) continue;

            // 킹이 돌 위치로 이동하는 경우
            if (nkx == sx && nky == sy) {
                int nsx = sx + d[0];
                int nsy = sy + d[1];

                // 돌이 범위 밖으로 나가면 무시
                if (nsx < 0 || nsx > 7 || nsy < 0 || nsy > 7) continue;

                sx = nsx;
                sy = nsy;
            }

            kx = nkx;
            ky = nky;
        }

        // 좌표 역변환
        System.out.println((char)(kx + 'A') + "" + (char)(ky + '1'));
        System.out.println((char)(sx + 'A') + "" + (char)(sy + '1'));
    }
}
