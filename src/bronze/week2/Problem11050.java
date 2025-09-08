package bronze.week2;

import java.util.Scanner;

//이항 계수 n! / k!(n-k)!
public class Problem11050 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(factorial(n) / (factorial(k)*(factorial(n-k))));
    }
    public static int factorial(int n) {
        if (n == 0 || n == 1) { // 기본(Base) 케이스: 0! 또는 1!은 1
            return 1;
        } else {
            return n * factorial(n - 1); // 재귀 호출
        }
    }
}
