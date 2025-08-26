package bronze.week1;

import java.util.Scanner;

public class Problem10871 {
    public static void main(String[] args){
        int b;
        int c;
        Scanner sc = new Scanner(System.in);
        c=sc.nextInt();
        b=sc.nextInt();
        int[] a = new int[c];
        for(int i=0; i<c; i++){
            a[i] = sc.nextInt();
        }
        for(int i=0;i<c; i++){
            if(a[i]<b){
                System.out.print(a[i]);
                System.out.print(" ");
            }
        }
    }
}
