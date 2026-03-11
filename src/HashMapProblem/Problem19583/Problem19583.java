package HashMapProblem.Problem19583;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem19583 {
    public static void main(String[] args) throws IOException {
        HashMap<String, Integer> map = new HashMap<>();
        int[][] date = new int[3][2];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String s = st.nextToken();
        String e = st.nextToken();
        String q = st.nextToken();

        StringTokenizer str1 = new StringTokenizer(s,":");
        date[0][0]=Integer.parseInt(str1.nextToken());
        date[0][1]=Integer.parseInt(str1.nextToken());
        StringTokenizer str2 = new StringTokenizer(e,":");
        date[1][0]=Integer.parseInt(str2.nextToken());
        date[1][1]=Integer.parseInt(str2.nextToken());
        StringTokenizer str3 = new StringTokenizer(q,":");
        date[2][0]=Integer.parseInt(str3.nextToken());
        date[2][1]=Integer.parseInt(str3.nextToken());
        int result = 0;
        int S = date[0][0] * 60 + date[0][1];
        int E = date[1][0] * 60 + date[1][1];
        int Q = date[2][0] * 60 + date[2][1];
        String line;
        while((line=br.readLine())!=null){
            StringTokenizer str = new StringTokenizer(line," ");
            String clock = str.nextToken();
            String name = str.nextToken();
            StringTokenizer hour = new StringTokenizer(clock, ":");
            int t = Integer.parseInt(hour.nextToken()) * 60 + Integer.parseInt(hour.nextToken());
            if(t <= S){
                map.put(name, map.getOrDefault(name, 0) | 1);
            }
            if(t >= E && t <= Q){
                map.put(name, map.getOrDefault(name, 0) | 2);
            }
        }
        for(int val : map.values()){
            if(val == 3) result++;
        }
        System.out.println(result);
    }
}
