package HashMapProblem.Problem1302;

import java.util.*;

public class Problem1302 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        //버퍼 비우기
        sc.nextLine();
        HashMap<String, Integer> hashMap = new HashMap<>();
        for(int i=0; i<x; i++){
            String s = sc.nextLine();
            hashMap.put(s, hashMap.getOrDefault(s,0)+1);
        }
        int max = Collections.max(hashMap.values());
        List<String> result = new ArrayList<>();
        for(String key : hashMap.keySet()){
            if(hashMap.get(key) == max) result.add(key);
        }
        
        //동일할 경우 사전순 정렬
        Collections.sort(result);
        System.out.println(result.get(0));
    }
}
