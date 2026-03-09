package HashMapProblem.Problem13414;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Problem13414 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int L = sc.nextInt();
        sc.nextLine();
        HashMap<String,Integer> map = new HashMap<>();
        ArrayList<String> result = new ArrayList<>();
        for(int i=0; i<L; i++){
            String student = sc.nextLine();
            map.put(student, i);
        }
        //result에 key값 담기
        result.addAll(map.keySet());

        //오름차순 정렬
        Collections.sort(result, (a, b) -> map.get(a) - map.get(b));

        for(int i =0; i<result.size(); i++) {
            if (i < K) {
                System.out.println(result.get(i));
            }
            else
                break;
        }
    }
}
