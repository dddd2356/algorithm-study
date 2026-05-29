import java.util.HashMap;

class Solution {
    public String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        
        char[] types = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
        for (char t : types) {
            map.put(t, 0);
        }
        
        for (int i = 0; i < survey.length; i++) {
            char first = survey[i].charAt(0);  
            char second = survey[i].charAt(1);
            int choice = choices[i];
            
            if (choice < 4) {
                map.put(first, map.get(first) + (4 - choice));
            } else if (choice > 4) {
                map.put(second, map.get(second) + (choice - 4));
            }
        }
        
        answer.append(map.get('R') >= map.get('T') ? 'R' : 'T');
        answer.append(map.get('C') >= map.get('F') ? 'C' : 'F');
        answer.append(map.get('J') >= map.get('M') ? 'J' : 'M');
        answer.append(map.get('A') >= map.get('N') ? 'A' : 'N');
        
        return answer.toString();
    }
}