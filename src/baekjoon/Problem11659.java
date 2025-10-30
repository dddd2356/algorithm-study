package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Problem11659 {
    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int M = sc.nextInt();
//        int[] num = new int[N];
//        int[] A = new int[N];
//        for(int i=0; i<num.length; i++){
//            num[i]=sc.nextInt();
//        }
//        for(int i=1; i<num.length; i++){
//            A[0] = num[0];
//            A[i] = A[i-1] + num[i];
//        }
//        for(int a=0; a<M; a++){
//            int i=sc.nextInt();
//            int j=sc.nextInt();
//            if(i == 1){
//                System.out.println(A[j-1]);
//            }
//            else
//                System.out.println(A[j-1] - A[i-2]);
//        }
//    }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int suNo  = Integer.parseInt(stringTokenizer.nextToken());
        int quizNo = Integer.parseInt(stringTokenizer.nextToken());
        long[] S = new long[suNo + 1];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i=1; i<= suNo; i++){
            S[i] = S[i-1] + Integer.parseInt(stringTokenizer.nextToken());
        }
        for(int q=0; q<quizNo; q++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int i = Integer.parseInt(stringTokenizer.nextToken());
            int j = Integer.parseInt(stringTokenizer.nextToken());
            System.out.println(S[j] - S[i-1]);
        }

    }
}
