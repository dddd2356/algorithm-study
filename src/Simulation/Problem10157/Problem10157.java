package Simulation.Problem10157;

import java.util.Scanner;

public class Problem10157 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt(); // 가로 (x 최대)
        int R = sc.nextInt(); // 세로 (y 최대)
        int K = sc.nextInt(); // 대기번호
        sc.close();

        if (K > C * R) { // 좌석 수보다 크면 불가능
            System.out.println(0);
            return;
        }

        // visited[x][y] 로 쓸 것이므로 크기는 [C+1][R+1], 1-based 인덱스 사용
        boolean[][] visited = new boolean[C + 1][R + 1];

        // 방향: 위, 오른쪽, 아래, 왼쪽 (시계방향)
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int x = 1, y = 1;          // 시작 좌표 (1,1)
        visited[x][y] = true;
        int cnt = 1;               // 이미 (1,1)에 첫번째 배정

        if (cnt == K) {
            System.out.println(x + " " + y);
            return;
        }

        int dir = 0; // 현재 방향: 0=위,1=오른쪽,2=아래,3=왼쪽
        while (cnt < K) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            // 범위를 벗어나거나 이미 방문한 자리면 방향 전환
            if (nx < 1 || nx > C || ny < 1 || ny > R || visited[nx][ny]) {
                dir = (dir + 1) % 4;
                continue;
            }

            // 이동해서 좌석 배정
            x = nx;
            y = ny;
            visited[x][y] = true;
            cnt++;

            if (cnt == K) {
                System.out.println(x + " " + y);
                return;
            }
        }
    }
}