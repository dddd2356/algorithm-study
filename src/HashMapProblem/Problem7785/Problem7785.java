package HashMapProblem.Problem7785;

import java.util.*;

public class Problem7785 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> map = new HashMap<>();
        int testCase = sc.nextInt();
        sc.nextLine();
        for(int i=0; i<testCase; i++){
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            String name = st.nextToken();
            String status = st.nextToken();
            int count = 0;
            if(status.equals("enter")){
                count=1;
            }
            else if(status.equals("leave")){
                count=0;
            }
            map.put(name, count);
        }
        ArrayList<String> result = new ArrayList<>();
        for (String key : map.keySet()) {
            if (map.get(key) == 1) result.add(key); // 현재 회사에 있는 사람
        }
        Collections.sort(result, Collections.reverseOrder());
        for(int i=0; i<result.size(); i++){
            System.out.println(result.get(i));
        }
    }
}
