package PriorityQueueProblem.Problem1927;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Problem1927 {
    public static void main(String[] args){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        for(int i=0; i<x; i++){
            int a = sc.nextInt();
            if(a==0){
                if(pq.isEmpty()){
                    System.out.println(0);
                }
                else {
                    System.out.println(pq.poll());
                }
            }
            else
                pq.add(a);
        }
    }
}
