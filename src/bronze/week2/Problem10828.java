package bronze.week2;

import java.util.Scanner;
import java.util.Stack;
public class Problem10828 {
    public static void main(String[] args){
        Stack<Integer> stackInt = new Stack<>();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i=0; i<N; i++){
            String a= sc.next();
            if(a.equals("push")){
                int value = sc.nextInt();
                stackInt.push(value);
            }
            else if(a.equals("top")){
                if(!stackInt.isEmpty()) {
                    System.out.println(stackInt.peek());
                }
                else
                    System.out.println("-1");
            }
            else if(a.equals("size")){
                System.out.println(stackInt.size());
            }
            else if(a.equals("empty")){
                if(stackInt.isEmpty()){
                    System.out.println("1");
                }
                else
                    System.out.println("0");
            }
            else if(a.equals("pop")){
               if(!stackInt.isEmpty()) {
                   int num = stackInt.pop();
                   System.out.println(num);
               }
               else
                   System.out.println("-1");
            }
        }
    }
}
