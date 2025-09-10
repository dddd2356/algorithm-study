package bronze.week2;

import java.util.Scanner;

public class Problem2920 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] a = new int[8];
        for(int i=0; i<8; i++){
            a[i] = sc.nextInt();
        }
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<8; i++){
            sb.append(a[i]);
        }
        if(sb.toString().equals("12345678")){
            System.out.println("ascending");
        }
        else if(sb.toString().equals("87654321")){
            System.out.println("descending");
        }
        else
            System.out.println("mixed");
    }
}
