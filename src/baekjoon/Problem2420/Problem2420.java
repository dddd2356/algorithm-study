package baekjoon.Problem2420;

import java.util.Scanner;

public class Problem2420 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        int count = 0;

        for(int i=0; i<N; i++){
            String arr = sc.nextLine();

            if(arr.equals("AA") || arr.equals("BB")) {
               count++;
               break;
            }

        }
        System.out.println(count);
    }
}
