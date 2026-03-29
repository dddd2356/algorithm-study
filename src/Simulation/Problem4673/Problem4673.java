package Simulation.Problem4673;

public class Problem4673 {
    // d(n) 계산: n + 각 자리수의 합
    private static int d(int n) {
        int result = n;
        int tmp = n;
        while (tmp > 0) {
            result += tmp % 10;
            tmp /= 10;
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        final int LIMIT = 10000;
        boolean[] generated = new boolean[LIMIT + 1];

        for (int i = 1; i <= LIMIT; i++) {
            int g = d(i);
            if (g <= LIMIT) generated[g] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= LIMIT; i++) {
            if (!generated[i]) sb.append(i).append('\n');
        }
        System.out.print(sb.toString());
    }
}
