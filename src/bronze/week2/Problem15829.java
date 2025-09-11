package bronze.week2;

import java.util.Scanner;

public class Problem15829 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        String str = sc.next();
        long Mod = 1234567891;
        long sum = 0;
        long pow =1;
        char[] hashing = new char[str.length()];
        for(int i=0; i<str.length(); i++) {
            hashing[i] = str.charAt(i);
        }
        for(int i=0; i<hashing.length; i++){
            int value = hashing[i]-'a'+1;
            sum = (sum + value * pow) % Mod;;
            pow = (pow * 31) % Mod;
        }
        System.out.println(sum);
    }
}
