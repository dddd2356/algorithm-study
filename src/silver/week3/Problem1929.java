package silver.week3;

import java.util.Scanner;

//이중포문을 사용해도 값이 나오지만 시간초과가 뜸. 그러므로 이중 포문 대신에 함수를 하나 만든 뒤 적용시키기
public class Problem1929 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        boolean[] c = new boolean[b-a+1];
        //int[] c = new int[b-a];

//        for(int i = 0; i<c.length; i++){
//            int count =0;
//            for(int j=1;j<=i+a;j++) {
//                if((i+a)%j==0) count++;
//            }
//            c[i]=count;
//        }
//        for(int i=0; i<c.length; i++) {
//            if (c[i] == 2) {
//                System.out.println(i + a);
//            }
//        }
        for(int i = 0; i<c.length; i++){
            c[i]=isPrime(i+a);
        }
        for(int i=0; i<c.length; i++) {
            if (c[i]) {
                System.out.println(i + a);
            }
        }
    }
    static boolean isPrime(int n) {
        if (n < 2) return false;
        for(int i = 2; i*i <= n; i++) {
            if(n % i == 0) return false;
        }
        return true;
    }
}