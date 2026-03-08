package baekjoon.Problem15964;

import java.util.Scanner;

public class Problem15964 {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        long a= sc.nextInt();
        long b= sc.nextInt();
        System.out.println((a+b) * (a-b));
    }
}
