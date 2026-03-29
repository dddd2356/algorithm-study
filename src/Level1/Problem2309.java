package Level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem2309 {
    static int[] num = new int[9];
    static int n=9, r=7;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            num[i] = Integer.parseInt(br.readLine());

        }
        makePermutation(n,r,0);
    }

    static void solve(){
        int sum =0;
        for(int i=0; i<r; i++){
            sum+=num[i];
        }
        if(sum==100){
            Arrays.sort(num,0,7);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < r; i++) sb.append(num[i]).append("\n");
            System.out.print(sb);
            System.exit(0);             // exit(0) 대응
        }
    }

    static void makePermutation(int n, int r, int depth){
        if(r==depth){
            solve();
            return;
        }
        for(int i= depth; i<n; i++){
            int tmp = num[i]; num[i] = num[depth]; num[depth] = tmp;
            makePermutation(n,r,depth+1);
            int tmp2 = num[i]; num[i] = num[depth]; num[depth] = tmp2;
        }
    }
}
