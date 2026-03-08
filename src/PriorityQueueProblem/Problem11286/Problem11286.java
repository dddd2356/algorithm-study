package PriorityQueueProblem.Problem11286;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Problem11286 {
    public static void main(String[] args){
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            if(Math.abs(a) != Math.abs(b))
                return Math.abs(a) - Math.abs(b);
            return a-b;
        });
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        for(int i=0; i<x; i++){
            int a = sc.nextInt();
            if(a==0){
                if(pq.isEmpty())
                    System.out.println(0);
                else
                    System.out.println(pq.poll());
            }
            else
                pq.add(a);
        }
    }
}
