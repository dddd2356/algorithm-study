package silver.week3;

import java.util.Scanner;

public class Problem14626 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        int m=0;
        int x = 1;
        for(int i=0;i<a.length();i++) {
            if (i % 2 == 0) {
                if (a.charAt(i) == '*') {
                    continue;
                }
                m = m + (a.charAt(i)-'0');
            } else {
                if (a.charAt(i) == '*') {
                    x = 3;
                    continue;
                }
                m = m + ((a.charAt(i)-'0') * 3);
            }
        }
        for(int i=0; i<10; i++){
            if((m +(x*i))%10 == 0){
                System.out.println(i);
            }
        }
    }
}
