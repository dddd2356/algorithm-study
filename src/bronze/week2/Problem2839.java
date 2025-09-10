package bronze.week2;

import java.util.Scanner;

public class Problem2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int minBundles = Integer.MAX_VALUE; // 초기값: 불가능

        // 5개 묶음 개수 탐색
        for (int fives = 0; fives <= X / 5; fives++) {
            int remaining = X - 5 * fives;

            // 남은 수가 3의 배수인지 확인
            if (remaining % 3 == 0) {
                int threes = remaining / 3;
                minBundles = Math.min(minBundles, fives + threes);
            }
        }

        if (minBundles == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(minBundles);
    }
}