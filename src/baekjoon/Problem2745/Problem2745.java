package baekjoon.Problem2745;

import java.util.Scanner;

public class Problem2745 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String N = sc.next();
        int B = sc.nextInt();

        long result = 0L;
        for (int i = 0; i < N.length(); i++) {
            char c = N.charAt(i);
            int value;
            if (Character.isDigit(c)) {
                value = c - '0';
            } else {
                value = Character.toUpperCase(c) - 'A' + 10;
            }
            if (value >= B) {
                throw new IllegalArgumentException("Digit '" + c + "' is not valid for base " + B);
            }
            result = result * B + value;
        }

        System.out.println(result);
        sc.close();
    }
}
