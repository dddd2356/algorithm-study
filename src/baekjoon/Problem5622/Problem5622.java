package baekjoon.Problem5622;

import java.util.Scanner;

public class Problem5622 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int result = 0;
        String a = sc.nextLine();
        for(int i=0; i<a.length(); i++) {
            result = result + dialNum(a.charAt(i));
        }
        System.out.println(result);
    }
    static int dialNum(char a){
        if(a == 'A' || a == 'B' || a=='C'){
            return 3;
        }
        else if(a == 'D' || a == 'E' || a=='F'){
            return 4;
        }

        else if(a == 'G' || a == 'H' || a=='I'){
            return 5;
        }

        else if(a == 'J' || a == 'K' || a=='L'){
            return 6;
        }

        else if(a == 'M' || a == 'N' || a=='O'){
            return 7;
        }

        else if(a == 'P' || a == 'Q' || a=='R' || a=='S'){
            return 8;
        }

        else if(a == 'T' || a == 'U' || a=='V'){
            return 9;
        }

        else if(a == 'W' || a == 'X' || a=='Y' || a== 'Z'){
            return 10;
        }

        else {
            return 11;
        }
    }
}
