import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        for(int i =0; i<N; i++){
            int num = sc.nextInt();
            if(num==0) {
                stack.pop();
            }
            else stack.add(num);
        }
        int sum =0;
        while(!stack.isEmpty()){
            sum += stack.pop();
        }
        System.out.println(sum);
    }
}