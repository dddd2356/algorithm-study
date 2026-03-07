package baekjoon.Problem2501;

import java.util.Scanner;

public class Problem2501 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        int q = sc.nextInt();
        int[] result = new int[p];
        int j=0;
        for(int i=1; i<=p; i++){
            if(p/i>0 && p%i==0){
                result[j]=i;
                j++;
            }
        }
        System.out.println(result[q-1]);
    }
}
