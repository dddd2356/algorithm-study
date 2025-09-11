package bronze.week2;

import java.util.*;

public class Problem2164 {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i=1; i<=N; i++){
            deque.add(i);
        }
        while(deque.size()!=1){
            deque.pop();
            int last = deque.pop();
            deque.addLast(last);
        }
        System.out.println(deque.getFirst());
    }
}