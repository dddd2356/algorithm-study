package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem16926 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 행
        int M = sc.nextInt(); // 열
        int R = sc.nextInt(); // 회전횟수

        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int layers = Math.min(N, M) / 2;

        for (int layer = 0; layer < layers; layer++) {
            int top = layer;
            int left = layer;
            int bottom = N - 1 - layer;
            int right = M - 1 - layer;

            // 1) 테두리 값들을 순서대로 리스트에 모음
            List<Integer> vals = new ArrayList<>();
            // top row (left -> right)
            for (int j = left; j <= right; j++) vals.add(arr[top][j]);
            // right col (top+1 -> bottom)
            for (int i = top + 1; i <= bottom; i++) vals.add(arr[i][right]);
            // bottom row (right-1 -> left) -- bottom>top일 때만
            if (bottom > top) {
                for (int j = right - 1; j >= left; j--) vals.add(arr[bottom][j]);
            }
            // left col (bottom-1 -> top+1) -- right>left일 때만
            if (right > left) {
                for (int i = bottom - 1; i > top; i--) vals.add(arr[i][left]);
            }

            int len = vals.size();
            int rotate = R % len; // 불필요한 회전 제거
            if (rotate == 0) continue;

            // 2) 왼쪽(반시계)으로 rotate: new[k] = vals[(k + rotate) % len]
            List<Integer> rotated = new ArrayList<>(len);
            for (int k = 0; k < len; k++) {
                rotated.add(vals.get((k + rotate) % len));
            }

            // 3) 다시 배열에 채워넣기 (같은 순서로)
            int idx = 0;
            for (int j = left; j <= right; j++) arr[top][j] = rotated.get(idx++);
            for (int i = top + 1; i <= bottom; i++) arr[i][right] = rotated.get(idx++);
            if (bottom > top) {
                for (int j = right - 1; j >= left; j--) arr[bottom][j] = rotated.get(idx++);
            }
            if (right > left) {
                for (int i = bottom - 1; i > top; i--) arr[i][left] = rotated.get(idx++);
            }
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(arr[i][j]);
                if (j < M - 1) sb.append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb.toString());
    }
}