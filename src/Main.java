import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String kingPos = st.nextToken();
        String stonePos = st.nextToken();
        int N = Integer.parseInt(st.nextToken());

        // 0-based 좌표: x = 0..7 (A..H), y = 0..7 (1..8)
        int kingX = kingPos.charAt(0) - 'A';
        int kingY = kingPos.charAt(1) - '1';
        int stoneX = stonePos.charAt(0) - 'A';
        int stoneY = stonePos.charAt(1) - '1';

        // 명령 -> dx, dy
        Map<String, int[]> map = new HashMap<>();
        map.put("R", new int[]{1, 0});
        map.put("L", new int[]{-1, 0});
        map.put("B", new int[]{0, -1});
        map.put("T", new int[]{0, 1});
        map.put("RT", new int[]{1, 1});
        map.put("LT", new int[]{-1, 1});
        map.put("RB", new int[]{1, -1});
        map.put("LB", new int[]{-1, -1});

        for (int i = 0; i < N; i++) {
            String cmd = br.readLine().trim();
            int[] d = map.get(cmd);
            if (d == null) continue; // 안전장치

            int nx = kingX + d[0];
            int ny = kingY + d[1];

            // 왕이 보드를 벗어나면 무시
            if (!inRange(nx, ny)) continue;

            // 왕이 돌이 있는 칸으로 가면 돌도 같은 방향으로 밀기
            if (nx == stoneX && ny == stoneY) {
                int sx = stoneX + d[0];
                int sy = stoneY + d[1];
                // 돌이 벗어나면 전체 명령 무시
                if (!inRange(sx, sy)) continue;
                // 돌 이동
                stoneX = sx;
                stoneY = sy;
            }

            // 왕 이동
            kingX = nx;
            kingY = ny;
        }

        // 출력: 다시 표기법으로
        System.out.println("" + (char)('A' + kingX) + (char)('1' + kingY));
        System.out.println("" + (char)('A' + stoneX) + (char)('1' + stoneY));
    }

    static boolean inRange(int x, int y) {
        return x >= 0 && x < 8 && y >= 0 && y < 8;
    }
}