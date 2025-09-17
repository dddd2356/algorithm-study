package silver.week3;

import java.util.Scanner;

public class Problem1018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        sc.nextLine();

        String[] a = new String[M];
        for (int i = 0; i < M; i++) {
            a[i] = sc.nextLine();
        }

        int result = 64; // 최악의 경우 (8x8 전부 다시 칠하기)

        // 모든 8x8 시작점 탐색
        for (int i = 0; i <= M - 8; i++) {
            for (int j = 0; j <= N - 8; j++) {
                int countW = 0; // (i,j) 시작점이 W일 때 바꿔야 하는 개수
                int countB = 0; // (i,j) 시작점이 B일 때 바꿔야 하는 개수

                // 8x8 영역 탐색
                for (int x = 0; x < 8; x++) {
                    for (int y = 0; y < 8; y++) {
                        char current = a[i + x].charAt(j + y);

                        // (x+y) 짝/홀에 따라 비교
                        if ((x + y) % 2 == 0) { // 짝수 칸
                            if (current != 'W') countW++; // W 시작일 때 다르면 +1
                            if (current != 'B') countB++; // B 시작일 때 다르면 +1
                        } else { // 홀수 칸
                            if (current != 'B') countW++;
                            if (current != 'W') countB++;
                        }
                    }
                }

                // 해당 8x8 최소값 반영
                result = Math.min(result, Math.min(countW, countB));
            }
        }

        System.out.println(result);
    }
}
