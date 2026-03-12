package Simulation.Problem2567;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2567 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int[][] board = new int[100][100];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for (int r = y; r < y + 10; r++)
                for (int c = x; c < x + 10; c++)
                    board[r][c] = 1;
        }

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int count = 0;

        for (int r = 0; r < 100; r++) {
            for (int c = 0; c < 100; c++) {
                if (board[r][c] == 1) {
                    for (int d = 0; d < 4; d++) {
                        int nr = r + dy[d];
                        int nc = c + dx[d];
                        // 경계 밖이거나 빈칸이면 둘레
                        if (nr < 0 || nr >= 100 || nc < 0 || nc >= 100 || board[nr][nc] == 0) {
                            count++;
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }

}
