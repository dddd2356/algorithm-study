package HashSetProblem.Problem11478;

import java.util.HashSet;
import java.util.Scanner;

public class Problem11478 {
    public static void main(String[] args){
        HashSet<String> set = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        for(int i=0; i<s.length(); i++){
            for(int j=i+1; j<=s.length(); j++){
                set.add(s.substring(i,j));
            }
        }
        System.out.println(set.size());
    }
}
