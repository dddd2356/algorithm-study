package HashMapProblem.Problem9375;

import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Problem9375 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        sc.nextLine();
        for(int i=0; i<testCase; i++) {
            int n = sc.nextInt();
            sc.nextLine();
            HashMap<String, Integer> map = new HashMap<>();
            for(int j=0; j<n; j++) {
                StringTokenizer st = new StringTokenizer(sc.nextLine());
                String name = st.nextToken();
                String type = st.nextToken();
                map.put(type, map.getOrDefault(type,0) + 1);
            }
            int result = 1;
            for (int count : map.values()) {
                result *= (count + 1);
            }
            result -= 1; // 아무것도 안 입는 경우 제외
            System.out.println(result);
        }
    }
}
