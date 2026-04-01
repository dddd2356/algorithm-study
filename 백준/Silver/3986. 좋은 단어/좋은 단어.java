import java.io.*;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int cnt = 0;
        for(int i=0; i<n; i++){
            Stack<Character> stack = new Stack<>();
            String s = sc.nextLine();
            for(int j=0; j<s.length(); j++) {
                char a = s.charAt(j);
                if(!stack.isEmpty() && a == stack.peek()){
                    stack.pop();
                }
                else stack.push(a);
            }
            if(stack.isEmpty()){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}