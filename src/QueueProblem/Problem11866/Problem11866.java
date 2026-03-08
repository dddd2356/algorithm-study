package QueueProblem.Problem11866;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem11866 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Queue<Integer> q = new LinkedList<>();
        int a = sc.nextInt();
        int b = sc.nextInt();
        for(int i=0; i<a; i++) {
            q.add(i+1);
        }
        System.out.print("<");
        while(!q.isEmpty()){
            for(int i=0; i<b-1; i++){
                q.add(q.poll());
            }
            System.out.print(q.poll());
            if(q.size() > 0) {
                System.out.print(", ");
            }
        }
        System.out.print(">");
    }
}