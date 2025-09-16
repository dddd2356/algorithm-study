package silver.week3;

import java.util.Scanner;

public class Problem9012 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        for(int i=0; i<T; i++) {
            String a = sc.nextLine();
            int xCount = 0;
            for (int j = 0; j < a.length(); j++) {
                if (a.charAt(j) == '(') {
                    xCount++;
                } else if (a.charAt(j) == ')') {
                    xCount--;
                    if(xCount<0){
                        break;
                    }
                }
            }
            if (xCount == 0) {
                System.out.println("YES");
            } else
                System.out.println("NO");
        }
    }
}

