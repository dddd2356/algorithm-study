package Simulation.Problem2161;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem2161 {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        ArrayList<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            result.add(queue.poll());
            queue.add(queue.peek());
            queue.remove(queue.peek());
        }

        for(int num : result){
            System.out.print(num+" ");
        }
    }
}
