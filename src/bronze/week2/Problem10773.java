package bronze.week2;

import java.util.Scanner;
import java.util.Stack;
public class Problem10773 {
    public static void main(String[] args){
        Stack<Integer> stackInt = new Stack<>();
        Scanner sc = new Scanner(System.in);
        int sum =0;
        int K= sc.nextInt();
        for(int i=0; i<K; i++){
            int num = sc.nextInt();
            if(num == 0){
                stackInt.pop();
            }
            else {
                stackInt.push(num);
            }
        }
        while(!stackInt.isEmpty()){
            int a = stackInt.pop();
            sum = sum+a;
        }
        System.out.print(sum);
    }
}
