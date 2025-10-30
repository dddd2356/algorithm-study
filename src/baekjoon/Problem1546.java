package baekjoon;

import java.util.Scanner;

public class Problem1546 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] num = new int[N];
        float max = 0;
        float sum = 0;
        sc.nextLine();
        for(int i=0; i<N; i++){
            num[i]=sc.nextInt();
            if(max<num[i])
                max = num[i];
        }
        for(int i=0; i<N; i++){
            sum += (num[i]/max)*100;
        }
        System.out.println(sum/N);
    }
}
