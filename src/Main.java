import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            String s = br.readLine();
            map.put(s, map.getOrDefault(s,0)+1);
        }

        String s;
        ArrayList<String> result = new ArrayList<>();
        result.addAll(map.keySet());
        while((s=br.readLine())!=null){
            if(map.containsKey(s)){
                map.put(s, map.get(s)-1);
            }
        }
        for(int i=0; i<map.size(); i++){
            if(map.get(result.get(i))!=0){
                System.out.println(result.get(i));
            }
        }
    }
}
