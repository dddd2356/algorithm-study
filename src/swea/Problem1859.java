package swea;

import java.util.Scanner;

public class Problem1859 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 0; tc < T; tc++) {
            int N = sc.nextInt();
            long[] num = new long[N];
            for (int i = 0; i < N; i++)
                num[i] = sc.nextLong();

            long sum = 0L;     // 구간에서 구매한 가격 합
            long count = 0L;   // 구간에서 구매한 개수
            long result = 0L;  // 총 이익

            for (int j = 0; j < N - 1; j++) {
                // 비감소(<=)로 묶어야 같았다가 오르는 경우도 포함됨
                if (num[j] <= num[j + 1]) {
                    sum += num[j];
                    count++;
                } else {
                    if (count > 0) {
                        // 구간의 마지막 값 num[j]에 팔기
                        result += (num[j] * count) - sum;
                        sum = 0L;
                        count = 0L;
                    }
                }
            }

            // 마지막에 남아있는 구간 처리 (배열 끝까지 증가했을 때)
            if (count > 0) {
                result += (num[N - 1] * count) - sum;
            }

            System.out.println("#"+(tc+1)+" " + result);
        }

        sc.close();
    }
}