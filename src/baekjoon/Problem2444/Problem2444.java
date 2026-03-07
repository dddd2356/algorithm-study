package baekjoon.Problem2444;

import java.util.Scanner;

public class Problem2444 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        // 윗부분 (1..n)
        for (int i = 1; i <= n; i++) {
            int spaces = n - i;
            int stars = 2 * i - 1;

            for (int s = 0; s < spaces; s++) System.out.print(" ");
            for (int t = 0; t < stars; t++) System.out.print("*");
            System.out.println();
        }

        // 아랫부분 (n-1..1)
        for (int i = n - 1; i >= 1; i--) {
            int spaces = n - i;
            int stars = 2 * i - 1;

            for (int s = 0; s < spaces; s++) System.out.print(" ");
            for (int t = 0; t < stars; t++) System.out.print("*");
            System.out.println();
        }
    }
}
