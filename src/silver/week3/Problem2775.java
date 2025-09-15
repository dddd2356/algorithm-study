package silver.week3;

import java.util.Scanner;

public class Problem2775 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i<T; i++){
            int k = sc.nextInt();
            int n = sc.nextInt();
            int[][] a = new int[k+1][n];
            int result = 0;
            for(int j=0; j<k+1;j++) {
                for(int z=0;z<n;z++){
                    if(z==0){
                        a[j][z]=1;
                    }
                    else if(j==0){
                        a[j][z] = a[j][z-1] + 1;
                    }
                    else {
                        for(int m=0; m<=z; m++) {
                            a[j][z] = a[j][z] + a[j - 1][m];
                        }
                    }
                }
            }
            result = a[k][n-1];
            System.out.println(result);
        }
    }
}
