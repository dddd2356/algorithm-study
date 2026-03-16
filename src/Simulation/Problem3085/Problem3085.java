package Simulation.Problem3085;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem3085 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        char[][] board = new char[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine().trim();
            for (int j = 0; j < N; j++) {
                board[i][j] = s.charAt(j);
            }
        }

        int answer = 0;

        // 각 칸에서 오른쪽과 아래로만 교환 시도 (중복 방지)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 오른쪽으로 swap
                if (j + 1 < N) {
                    swap(board, i, j, i, j + 1);
                    answer = Math.max(answer, maxConsecutive(board));
                    swap(board, i, j, i, j + 1); // 되돌리기
                }
                // 아래로 swap
                if (i + 1 < N) {
                    swap(board, i, j, i + 1, j);
                    answer = Math.max(answer, maxConsecutive(board));
                    swap(board, i, j, i + 1, j); // 되돌리기
                }
            }
        }

        System.out.println(answer);
    }

    // 두 위치의 값을 교환
    private static void swap(char[][] b, int r1, int c1, int r2, int c2) {
        char tmp = b[r1][c1];
        b[r1][c1] = b[r2][c2];
        b[r2][c2] = tmp;
    }

    // 보드 전체에서 행별/열별 연속된 동일 문자 최대 길이 반환
    private static int maxConsecutive(char[][] b) {
        int N = b.length;
        int max = 0;

        // 행 검사
        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 1; j < N; j++) {
                if (b[i][j] == b[i][j - 1]) {
                    count++;
                } else {
                    max = Math.max(max, count);
                    count = 1;
                }
            }
            max = Math.max(max, count);
        }

        // 열 검사
        for (int j = 0; j < N; j++) {
            int count = 1;
            for (int i = 1; i < N; i++) {
                if (b[i][j] == b[i - 1][j]) {
                    count++;
                } else {
                    max = Math.max(max, count);
                    count = 1;
                }
            }
            max = Math.max(max, count);
        }

        return max;
    }
}