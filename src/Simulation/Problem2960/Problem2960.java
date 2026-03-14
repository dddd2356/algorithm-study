package Simulation.Problem2960;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2960 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String number= br.readLine();
        StringTokenizer st = new StringTokenizer(number);
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[N+1];
        int count = 0;
        for(int i=2; i<=N; i++){
            if(!visited[i]){
                for(int j=i; j<=N; j+=i){
                    if(!visited[j]) {
                        visited[j] = true;
                        count++;
                        if (count == K) {
                            System.out.println(j);
                            break;
                        }
                    }
                }
            }
        }
    }
}
