package Problem4358;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


public class Problem4358 {
    public static void main(String[] args) throws IOException {
        HashMap<String,Integer> map = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> result = new ArrayList<>();
        double total=0;
        String s;
        while((s=br.readLine())!=null){
            map.put(s, map.getOrDefault(s,0)+1);
            total++;
        }
        result.addAll(map.keySet());
        Collections.sort(result);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<result.size(); i++){
            String avg = String.format("%.4f",map.get(result.get(i))/total*100);
            sb.append(result.get(i)).append(" ").append(avg).append("\n");
        }
        System.out.println(sb);
    }
}
