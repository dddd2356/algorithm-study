import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        HashMap<String,Integer> map = new HashMap<>();
        double total=0;
        while((s=br.readLine())!=null){
            map.put(s, map.getOrDefault(s,0)+1);
            total++;
        }
        ArrayList<String> result = new ArrayList<>();
        result.addAll(map.keySet());
        Collections.sort(result);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<result.size(); i++){
            String avg = String.format("%.4f", map.get(result.get(i))/total*100);
            sb.append(result.get(i)).append(" ").append(avg).append("\n");
        }
        System.out.println(sb);
    }
}
