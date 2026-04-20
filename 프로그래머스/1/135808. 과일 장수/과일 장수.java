import java.io.*;
import java.util.*;


class Solution {
    public int solution(int k, int m, int[] score) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        ArrayList<Integer> result = new ArrayList<>();
        int total=0;
        
        for (int s : score) {
            pq.add(s);
        }
        
        while(!pq.isEmpty() && pq.size()>=m) {
            for (int i = 0; i < m; i++) {
                result.add(pq.poll());
            }
            total+= result.get(result.size() - 1) * m;
        }
        
        return total;
    }
}