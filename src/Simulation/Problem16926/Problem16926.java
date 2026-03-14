package Simulation.Problem16926;

import java.util.Scanner;

public class Problem16926 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int R = sc.nextInt();

        int[][] arr = new int[N][M];

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                arr[i][j] = sc.nextInt();
            }
        }

        int layer = Math.min(N,M)/2;

        for(int r=0; r<R; r++){

            for(int l=0; l<layer; l++){

                int temp = arr[l][l];

                // 위
                for(int i=l; i<M-l-1; i++){
                    arr[l][i] = arr[l][i+1];
                }

                // 오른쪽
                for(int i=l; i<N-l-1; i++){
                    arr[i][M-l-1] = arr[i+1][M-l-1];
                }

                // 아래
                for(int i=M-l-1; i>l; i--){
                    arr[N-l-1][i] = arr[N-l-1][i-1];
                }

                // 왼쪽
                for(int i=N-l-1; i>l; i--){
                    arr[i][l] = arr[i-1][l];
                }

                arr[l+1][l] = temp;
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}