package bronze.week1;

import java.util.Scanner;

public class Problem2441 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a= sc.nextInt();
        for(int i=0; i<a; i++){
            for(int j=5;j>i;j--){
                for(int z=5;z<j; z++){
                    System.out.print(" ");
                }
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
