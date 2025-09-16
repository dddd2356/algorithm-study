package silver.week3;

import java.util.Scanner;
import java.util.Stack;


//Problem9012괄호 문제처럼 순서 상관없이 사용하게 되어지면 COUNT를 해도 되지만 순서를 고려해야한다면 스택을 써야함.
public class Problem4949 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while(true){
            String a = sc.nextLine();
            if(a.charAt(0) == '.') break; // 종료 조건

            Stack<Character> stack = new Stack<>();
            boolean isValid = true;

            for(int j=0; j<a.length(); j++){
                char ch = a.charAt(j);

                if(ch == '(' || ch == '['){
                    stack.push(ch);
                }
                else if(ch == ')'){
                    if(stack.isEmpty() || stack.peek() != '('){
                        isValid = false;
                        break;
                    }
                    stack.pop();
                }
                else if(ch == ']'){
                    if(stack.isEmpty() || stack.peek() != '['){
                        isValid = false;
                        break;
                    }
                    stack.pop();
                }
            }

            if(isValid && stack.isEmpty()){
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
