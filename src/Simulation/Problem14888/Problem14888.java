package Simulation.Problem14888;

import java.util.Scanner;

public class Problem14888 {
    static int N;
    static int[] num;
    static int[] ops = new int[4]; // 0:+, 1:-, 2:*, 3:/
    static long maxAns = Long.MIN_VALUE;
    static long minAns = Long.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        num = new int[N];
        for (int i = 0; i < N; i++) num[i] = sc.nextInt();
        for (int i = 0; i < 4; i++) ops[i] = sc.nextInt();

        dfs(1, num[0]); // idx = 다음 숫자 인덱스, current = 현재 계산값
        System.out.println(maxAns);
        System.out.println(minAns);
    }

    static void dfs(int idx, long current) {
        if (idx == N) {
            if (current > maxAns) maxAns = current;
            if (current < minAns) minAns = current;
            return;
        }

        int next = num[idx];
        // plus
        if (ops[0] > 0) {
            ops[0]--;
            dfs(idx + 1, current + next);
            ops[0]++;
        }
        // minus
        if (ops[1] > 0) {
            ops[1]--;
            dfs(idx + 1, current - next);
            ops[1]++;
        }
        // multiply
        if (ops[2] > 0) {
            ops[2]--;
            dfs(idx + 1, current * next);
            ops[2]++;
        }
        // divide
        if (ops[3] > 0) {
            ops[3]--;
            // Java의 정수 나눗셈은 음수에 대해 0 쪽으로 버림(truncate toward zero) 하므로 그대로 사용해도 문제 요구사항과 일치.
            // 안전하게 하려면 아래처럼 절댓값 나눗셈 후 부호 적용 방식으로 해도 된다:
            // long divResult = Math.abs(current) / Math.abs(next);
            // if ((current < 0 && next > 0) || (current > 0 && next < 0)) divResult = -divResult;
            // dfs(idx + 1, divResult);
            dfs(idx + 1, current / next);
            ops[3]++;
        }
    }
}