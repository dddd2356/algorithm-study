package HashMapProblem.Problem11652;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Problem11652 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long N = sc.nextInt();
        sc.nextLine();
        int max = 0;
        HashMap<Long, Integer> hashMap = new HashMap<>();
        ArrayList<Long> result = new ArrayList<>();
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i=0;i<N; i++){
            long num = sc.nextLong();
            hashMap.put(num, hashMap.getOrDefault(num, 0)+1);
        }
        result.addAll(hashMap.keySet());
        for(int i=0; i<hashMap.size(); i++){
            if(hashMap.get(result.get(i))>max){
                max = hashMap.get(result.get(i));
            }
        }
        for(int i=0; i<hashMap.size(); i++) {
            if(max == hashMap.get(result.get(i))) {
                pq.add(result.get(i));
            }
        }
        System.out.println(pq.peek());
    }
}
