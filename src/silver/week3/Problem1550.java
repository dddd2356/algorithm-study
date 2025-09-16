package silver.week3;

import java.util.Scanner;

public class Problem1550 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        int count = 0;
        for(int i=a.length(); i>0; i--){
            if(a.charAt(i)>='A' && a.charAt(i)<='Z'){
                count = count + (16*i*(a.charAt(i)-'A'+10));
            }
            else if(a.charAt(i)>='0' && a.charAt(i)<='9'){
                count = count + (16*i*(a.charAt(i)-'0'));
            }
        }
        System.out.println(count);
    }
}