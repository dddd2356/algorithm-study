package Simulation.Problem14503;

import java.util.Scanner;

public class Problem14503 {

    static int N, M;
    static int[][] map;

    // 북 동 남 서
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        int r = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int count = 0;

        while (true) {

            // 1 현재 칸 청소
            if (map[r][c] == 0) {
                map[r][c] = 2;
                count++;
            }

            boolean moved = false;

            // 2 네 방향 확인
            for (int i = 0; i < 4; i++) {

                // 왼쪽 회전
                d = (d + 3) % 4;

                int nx = r + dx[d];
                int ny = c + dy[d];

                if (map[nx][ny] == 0) {
                    r = nx;
                    c = ny;
                    moved = true;
                    break;
                }
            }

            // 3 네 방향 다 못감
            if (!moved) {

                int back = (d + 2) % 4;

                int nx = r + dx[back];
                int ny = c + dy[back];

                // 뒤가 벽이면 종료
                if (map[nx][ny] == 1) {
                    break;
                }

                // 뒤로 이동
                r = nx;
                c = ny;
            }
        }

        System.out.println(count);
    }
}