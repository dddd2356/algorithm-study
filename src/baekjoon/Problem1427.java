package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Problem1427 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String arr = sc.nextLine();
        char[] arr2;
        arr2 = arr.toCharArray();
        Arrays.sort(arr2);
        for(int i=arr.length()-1; i>=0; i--){
            System.out.print(arr2[i]);
        }
    }
}
