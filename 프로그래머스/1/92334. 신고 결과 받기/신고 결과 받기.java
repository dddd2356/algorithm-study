import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        HashSet<String> reportSet = new HashSet<>(Arrays.asList(report));
        
        HashMap<String, Integer> countMap = new HashMap<>();
        for (String rep : reportSet) {
            String receiver = rep.split(" ")[1];
            countMap.put(receiver, countMap.getOrDefault(receiver, 0) + 1);
        }
        
        for (String rep : reportSet) {
            String[] split = rep.split(" ");
            String reporter = split[0];
            String receiver = split[1];
            
            if (countMap.getOrDefault(receiver, 0) >= k) {
                for (int i = 0; i < id_list.length; i++) {
                    if (id_list[i].equals(reporter)) {
                        answer[i]++;
                        break;
                    }
                }
            }
        }
        
        return answer;
    }
}