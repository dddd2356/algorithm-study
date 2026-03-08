package PriorityQueueProblem.Problem11279;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Problem11279 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0; i<x; i++){
            int a = sc.nextInt();
            pq.add(a);
            if(a==0){
                System.out.println(pq.poll());
            }
        }
    }
}
