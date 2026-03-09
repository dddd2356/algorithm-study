package HashMapProblem.Problem20291;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Problem20291 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(),".");
            String name = st.nextToken();
            String type = st.nextToken();
            map.put(type,map.getOrDefault(type,0)+1);
        }
        ArrayList<String> result = new ArrayList<>();
        result.addAll(map.keySet());
        Collections.sort(result);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<map.size(); i++){
            sb.append(result.get(i)).append(" ").append(map.get(result.get(i))).append("\n");
        }
        System.out.println(sb);
    }
}
