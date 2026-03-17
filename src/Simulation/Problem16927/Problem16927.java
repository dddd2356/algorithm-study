package Simulation.Problem16927;

import java.util.*;

public class Problem16927 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 행 수
        int M = sc.nextInt(); // 열 수
        int R = sc.nextInt(); // 회전 수
        int[][] a = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        sc.close();

        int layers = Math.min(N, M) / 2;
        // 순서: 오른쪽, 아래, 왼쪽, 위 (시계 방향으로 둘레를 따라감)
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        for (int layer = 0; layer < layers; layer++) {
            int sr = layer, sc0 = layer;               // 시작 좌표 (layer, layer)
            int rows = N - 2 * layer;                 // 현재 레이어의 행 개수
            int cols = M - 2 * layer;                 // 현재 레이어의 열 개수

            // 둘레 길이 계산: 행 또는 열이 1이면 특수 처리
            int perim = (rows == 1 || cols == 1) ? rows * cols : 2 * (rows + cols) - 4;
            if (perim == 0) continue;

            // 1) 둘레의 요소를 순서대로 추출하여 elems에 저장
            List<Integer> elems = new ArrayList<>(perim);
            int r = sr, c = sc0, dir = 0;
            for (int t = 0; t < perim; t++) {
                elems.add(a[r][c]);
                int nr = r + dr[dir], nc = c + dc[dir];
                if (nr < layer || nr >= N - layer || nc < layer || nc >= M - layer) {
                    dir = (dir + 1) % 4;
                    nr = r + dr[dir];
                    nc = c + dc[dir];
                }
                r = nr; c = nc;
            }

            // 2) 회전값 계산 (rot만 사용) — rotated 리스트는 만들지 않음
            int rot = R % perim;

            // 3) 회전된 인덱스를 계산해서 바로 배열에 채워넣기
            r = sr; c = sc0; dir = 0;
            for (int t = 0; t < perim; t++) {
                // t번째 위치에는 elems의 (t + rot) % perim 값이 들어감 (왼쪽으로 rot 회전)
                a[r][c] = elems.get((t + rot) % perim);
                int nr = r + dr[dir], nc = c + dc[dir];
                if (nr < layer || nr >= N - layer || nc < layer || nc >= M - layer) {
                    dir = (dir + 1) % 4;
                    nr = r + dr[dir];
                    nc = c + dc[dir];
                }
                r = nr; c = nc;
            }
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(a[i][j]);
                if (j != M - 1) sb.append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb.toString());
    }
}