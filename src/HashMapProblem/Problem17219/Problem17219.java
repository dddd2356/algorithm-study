package HashMapProblem.Problem17219;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Problem17219 {
    public static void main(String[] args) throws IOException {
        HashMap<String, String> map = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<String> result = new ArrayList<>();
        for(int i=0; i<N; i++){
            StringTokenizer str = new StringTokenizer(br.readLine());
            map.put(str.nextToken(), str.nextToken());
        }
        for(int i=0; i<M; i++) {
            String s = br.readLine();
            if(map.containsKey(s)){;
                result.add(map.get(s));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i)).append("\n");
        }
        System.out.print(sb);
    }
}
