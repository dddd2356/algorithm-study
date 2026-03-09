package HashMapProblem.Problem1764;

import java.util.*;

public class Problem1764 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        HashMap<String,Integer> map = new HashMap<>();
        ArrayList<String> result = new ArrayList<>();
        for(int i=0; i<N+M;i++){
            String s = sc.nextLine();
            map.put(s, map.getOrDefault(s,0)+1);
            if(map.get(s) == 2){
                result.add(s);
            }
        }
        Collections.sort(result);
        System.out.println(result.size());
        for(int i=0; i<result.size(); i++){
            System.out.println(result.get(i));
        }
    }
}
