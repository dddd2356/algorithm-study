package HashSetProblem.Problem5568;

import java.util.HashSet;
import java.util.Scanner;

public class Problem5568 {
    static int n,k;
    static boolean[] visited;
    static String[] num;
    static HashSet<String> result = new HashSet<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        sc.nextLine();
        num = new String[n];
        visited = new boolean[n];

        for(int i=0; i<n; i++){
            num[i] = sc.nextLine();
        }
        line("",0);
        System.out.println(result.size());
    }

    static void line(String a, int depth){
        if(depth == k){
            result.add(a);
            return;
        }
        for(int i=0; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                line(a+num[i], depth+1);
                visited[i] = false;
            }
        }
    }
}