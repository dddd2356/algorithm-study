package bronze.week2;

import java.util.*;

public class Problem10845 {
    public static void main(String[] args){
        Queue<Integer> queue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Integer lastValue =null;
        for(int i=0; i<N; i++){
            String a= sc.next();
            if(a.equals("push")){
                int value = sc.nextInt();
                queue.add(value);
            }
            else if(a.equals("front")){
                if(!queue.isEmpty()) {
                    System.out.println(queue.peek());
                }
                else
                    System.out.println("-1");
            }
            else if(a.equals("back")){
                if(!queue.isEmpty()) {
                    for(Integer value : queue)
                        lastValue = value;
                    System.out.println(lastValue);
                }

                else
                    System.out.println("-1");
            }
            else if(a.equals("size")){
                System.out.println(queue.size());
            }
            else if(a.equals("empty")){
                if(queue.isEmpty()){
                    System.out.println("1");
                }
                else
                    System.out.println("0");
            }
            else if(a.equals("pop")){
                if(!queue.isEmpty()) {
                    int num = queue.poll();
                    System.out.println(num);
                }
                else
                    System.out.println("-1");
            }
        }
    }
}
