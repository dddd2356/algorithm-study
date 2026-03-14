package Simulation.Problem20053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem20053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<testCase; i++){
            int n = Integer.parseInt(br.readLine());
            int[] num = new int[n];
            String number = br.readLine();
            StringTokenizer st = new StringTokenizer(number," ");
            for(int j=0; j<n; j++){
                num[j]=Integer.parseInt(st.nextToken());
            }
            Arrays.sort(num);
            sb.append(num[0]).append(" ").append(num[n-1]).append("\n");
        }
        System.out.println(sb);
    }
}
