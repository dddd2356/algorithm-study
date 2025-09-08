package bronze.week2;

import java.util.Scanner;

public class Problem2292 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int level = 1; //범위
        int b = 2; //시작값
        while(true) {
            if (b <= a) {
                b = b + (6*level);
                level++;
            }
            else
                break;
        }
        System.out.println(level);
    }
}
