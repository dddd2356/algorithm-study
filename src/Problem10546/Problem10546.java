package Problem10546;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


public class Problem10546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] setA = new String[n];
        HashMap<String,Integer> map = new HashMap<>();

        for(int i=0; i<n; i++){
            setA[i]=br.readLine();
        }
        for (int i = 0; i < n - 1; i++) {
            String name = br.readLine();
            map.put(name, map.getOrDefault(name, 0) + 1);  // setB를 map에 카운트
        }

        for (int i = 0; i < n; i++) {
            if (map.getOrDefault(setA[i], 0) == 0) {  // map에 없으면 정답
                System.out.println(setA[i]);
                break;
            }
            map.put(setA[i], map.get(setA[i]) - 1);  // 있으면 카운트 차감
        }
    }
}
