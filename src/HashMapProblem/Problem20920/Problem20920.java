package HashMapProblem.Problem20920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        for(int i=0; i<N; i++){
            String s = br.readLine();
            map.put(s,map.getOrDefault(s,0)+1);
        }
        for(String key : map.keySet()){
            if(key.length() >= M) result.add(key);
        }
        Collections.sort(result, (a, b) -> {
            if (map.get(b) != map.get(a)) return map.get(b) - map.get(a); // 빈도 내림차순
            if (b.length() != a.length()) return b.length() - a.length(); // 길이 내림차순
            return a.compareTo(b);                                         // 사전순
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i)).append("\n");
        }
        System.out.print(sb);
    }
}
