package bronze.week2;

import java.util.Scanner;

public class Problem2869 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int v = sc.nextInt();
        int day = (v-a)/(a-b)+1;
        if((v-a)%(a-b)!=0){
            day++;
        }
        System.out.print(day);
    }
}
