package baekjoon.Problem2754;

import java.util.Scanner;

public class Problem2754 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        double avg = 0.0;
        if(a.charAt(0)=='A'){
            avg = avg + 4.0;
            if(a.charAt(1)=='+'){
                avg = avg + 0.3;
            }
            else if(a.charAt(1)=='-') {
                avg = avg - 0.3;
            }
        }
        else if(a.charAt(0)=='B'){
            avg = avg + 3.0;
            if(a.charAt(1)=='+'){
                avg = avg + 0.3;
            }
            else if(a.charAt(1)=='-') {
                avg = avg - 0.3;
            }
        }
        else if(a.charAt(0)=='C'){
            avg = avg + 2.0;
            if(a.charAt(1)=='+'){
                avg = avg + 0.3;
            }
            else if(a.charAt(1)=='-') {
                avg = avg - 0.3;
            }
        }
        else if(a.charAt(0)=='D'){
            avg = avg + 1.0;
            if(a.charAt(1)=='+'){
                avg = avg + 0.3;
            }
            else if(a.charAt(1)=='-') {
                avg = avg - 0.3;
            }
        }
        else {
            avg = 0;
        }
        System.out.println(avg);
    }
}
