package HashSetProblem.Problem1316;

import java.util.HashSet;
import java.util.Scanner;

public class Problem1316 {
    static int N;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N=sc.nextInt();
        sc.nextLine();
        String a;
        int count=0;
        for(int i=0; i<N; i++) {
            boolean isTrue = true;
            a = sc.nextLine();
            HashSet<Character> hashSet = new HashSet<>();
            //이전것과 다른데 그 앞에거는 이전에 중복된거
            hashSet.add(a.charAt(0));
            for (int j = 1; j < a.length(); j++) {
                if ((a.charAt(j-1) != a.charAt(j))) {
                    if(!hashSet.add(a.charAt(j))){
                        isTrue = false;
                        break;
                    }
                }
            }
            if(isTrue){
                count++;
            }
        }
        System.out.println(count);
    }
}
