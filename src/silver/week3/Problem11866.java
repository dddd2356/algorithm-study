package silver.week3;

import java.util.LinkedList;
import java.util.Scanner;

public class Problem11866 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        sc.nextLine();
        LinkedList<Integer> list = new LinkedList<>();
        int[] result = new int[N];
        for(int i=1; i<=N; i++){
            list.add(i);
        }
        int index = 0;
        for(int i=0; i<N; i++){
            index = (index+K-1) % list.size(); // K번째 사람을 뽑는 규칙
            result[i] = list.remove(index);
        }
        System.out.print("<");
        for(int i=0; i<N; i++) {
            if(i==N-1){
                System.out.print(result[i] + ">");
            }
            else
                System.out.print(result[i] + ", ");
        }
    }
}
