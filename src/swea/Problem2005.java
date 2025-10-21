package swea;

import java.util.Scanner;

public class Problem2005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 수 입력

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt(); // 삼각형의 크기 입력
            int[][] arr = new int[N][N]; // 2차원 배열 생성

            // ✅ 파스칼의 삼각형 생성
            for (int i = 0; i < N; i++) {
                for (int j = 0; j <= i; j++) {
                    // 각 줄의 첫 번째와 마지막은 항상 1
                    if (j == 0 || j == i) {
                        arr[i][j] = 1;
                    } else {
                        // 중간 값 = 바로 위 줄의 왼쪽 + 바로 위 줄의 오른쪽
                        arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                    }
                }

                // ✅ 한 줄씩 출력
                for (int j = 0; j <= i; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println(); // 줄 바꿈
            }
        }

        sc.close();
    }
}
