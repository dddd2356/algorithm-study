package bronze.week2;

import java.util.Scanner;

public class Problem2475 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] a = new int[5];
        int sum = 0;

        for(int i=0; i<a.length; i++){
            a[i] = sc.nextInt();
        }

        for(int i=0; i<a.length; i++){
            sum = sum + (a[i]*a[i]);
        }
        int result = sum%10;
        System.out.println(result);
    }
}
