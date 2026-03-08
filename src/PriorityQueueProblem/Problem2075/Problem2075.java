package PriorityQueueProblem.Problem2075;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Problem2075 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++){
                int a = sc.nextInt();
                pq.add(a);
                if(pq.size()>N)
                    pq.poll();
            }
        }
        System.out.println(pq.peek());
    }
}
