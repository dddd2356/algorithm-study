package StackProblem.Problem10773;

import java.util.Scanner;
import java.util.Stack;

public class Problem10773 {
    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int result = 0;
        for(int i=0; i<a; i++){
            int b = sc.nextInt();
            if(b==0){
                stack.pop();
            }
            else
                stack.push(b);
        }
        while(!stack.isEmpty()){
            result = result + stack.pop();
        }
        System.out.println(result);
    }
}
