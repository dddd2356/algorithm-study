package HashMapProblem.Problem16165;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Problem16165 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        HashMap<String, ArrayList<String>> groupMap = new HashMap<>();

        for(int i=0; i<N; i++){
            String group = sc.nextLine();
            groupMap.put(group, new ArrayList<>());
            int count = sc.nextInt();
            sc.nextLine();
            for(int j=0; j<count; j++){
                String name = sc.nextLine();
                groupMap.get(group).add(name);
            }
        }

        ArrayList<String> result = new ArrayList<>();
        result.addAll(groupMap.keySet());

        for(int i=0; i<M; i++){
            String s = sc.nextLine();
            int quiz = sc.nextInt();
            sc.nextLine();
            if(quiz==1) {
                Collections.sort(result);
                for (String group : result) {
                    if (groupMap.get(group).contains(s)) {
                        System.out.println(group);
                        break;
                    }
                }
            }
            else {
                    ArrayList<String> members = groupMap.get(s);
                    Collections.sort(members); // 사전순
                    for (String m : members) System.out.println(m);
            }
        }
    }
}
