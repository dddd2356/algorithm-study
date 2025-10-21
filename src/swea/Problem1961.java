package swea;

import java.util.Scanner;

public class Problem1961 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 수

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();             // 배열 크기
            int[][] arr = new int[N][N];      // 원본 배열

            // 배열 입력
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            // 회전 배열 생성
            int[][] rot90 = new int[N][N];
            int[][] rot180 = new int[N][N];
            int[][] rot270 = new int[N][N];

            // 회전 공식 적용
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    rot90[i][j] = arr[N - 1 - j][i];       // 90도
                    rot180[i][j] = arr[N - 1 - i][N - 1 - j]; // 180도
                    rot270[i][j] = arr[j][N - 1 - i];       // 270도
                }
            }

            // SWEA 형식 출력
            System.out.println("#" + tc);
            for (int i = 0; i < N; i++) {
                // 90도 회전 출력
                for (int j = 0; j < N; j++) System.out.print(rot90[i][j]);
                System.out.print(" ");

                // 180도 회전 출력
                for (int j = 0; j < N; j++) System.out.print(rot180[i][j]);
                System.out.print(" ");

                // 270도 회전 출력
                for (int j = 0; j < N; j++) System.out.print(rot270[i][j]);
                System.out.println(); // 줄 바꿈
            }
        }

        sc.close();
    }
}
