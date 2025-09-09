package bronze.week2;

import java.util.Scanner;

public class Problem2675 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine(); // 엔터 처리

        for(int j = 0; j < N; j++) {
            String[] parts = sc.nextLine().split(" "); // "3 ABC"
            int R = Integer.parseInt(parts[0]);       // 반복 횟수
            String S = parts[1];                      // 문자열

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < S.length(); i++){
                for(int k = 0; k < R; k++){
                    sb.append(S.charAt(i));
                }
            }
            System.out.println(sb.toString());
        }
    }
}
