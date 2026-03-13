package Simulation.Problem1051;

import java.util.Scanner;

public class Problem1051 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        int[][] num = new int[N][M];
        int max = 1;

        for(int i=0; i<N; i++){
            String s = sc.next().trim();
            for(int j=0; j<M; j++){
                num[i][j] = s.charAt(j)-'0';
            }
        }

        for(int i=0; i<N;i++){
            for(int j=0; j<M; j++){
               int standard = num[i][j];
               for(int z=1; i + z < N && j + z < M; z++){
                       if ((standard == num[i + z][j]) &&
                               (standard == num[i][j + z]) &&
                               (standard == num[i + z][j + z])
                       ) {
                           max = Math.max(max,(z+1) * (z+1));
                       }

               }
            }
        }
        System.out.println(max);
    }
}
