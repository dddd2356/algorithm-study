package swea;

import java.util.Scanner;

public class Problem2001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 수 입력

        // 각 테스트 케이스마다 반복
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt(); // 방 크기 N
            int M = sc.nextInt(); // 파리채 크기 M
            int[][] arr = new int[N][N]; // 파리 수 배열 생성

            // 배열 값 입력
            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++)
                    arr[i][j] = sc.nextInt();

            int maxSum = 0; // 최대 합 초기화

            // M×M 영역을 시작점 (i,j) 기준으로 탐색
            for (int i = 0; i <= N - M; i++) { // i : 행 시작 위치
                for (int j = 0; j <= N - M; j++) { // j : 열 시작 위치
                    int sum = 0; // 현재 영역 합 초기화

                    // 현재 M×M 영역 합 계산
                    for (int x = i; x < i + M; x++) { // 영역 내 행
                        for (int y = j; y < j + M; y++) { // 영역 내 열
                            sum += arr[x][y]; // 영역 합 누적
                        }
                    }

                    // 최대 합 갱신
                    if (sum > maxSum)
                        maxSum = sum;
                }
            }

            // 결과 출력 (SWEA 제출 형식)
            System.out.println("#" + tc + " " + maxSum);
        }
        sc.close();
    }
}

