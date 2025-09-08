package bronze.week2;

import java.util.Scanner;

public class Problem2231 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int result = 0;
        for(int i=0; i<a; i++){
            int number = i;
            int sum =0;
            while (number!=0){
                sum += number%10;
                number/=10;
            }

            if(sum + i == a){
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}
