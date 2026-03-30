import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        sc.nextLine();
        int num;
        int[] psum = new int[1000001];
        int max = -10000004;
        for(int i=1; i<=N; i++){
            num=sc.nextInt();
            psum[i]=psum[i-1]+num;
        }
        for(int i=K; i<=N; i++){
            max= Math.max(max, psum[i]-psum[i-K]);
        }
        System.out.println(max);
    }
}