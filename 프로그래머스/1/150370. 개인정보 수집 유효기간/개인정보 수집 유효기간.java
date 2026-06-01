import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> expiredList = new ArrayList<>();
        
        int todayDays = convertToDays(today);
        
        Map<String, Integer> termMap = new HashMap<>();
        for (String term : terms) {
            String[] splitTerm = term.split(" ");
            String type = splitTerm[0];
            int month = Integer.parseInt(splitTerm[1]);
            termMap.put(type, month);
        }
        
        for (int i = 0; i < privacies.length; i++) {
            String[] splitPrivacy = privacies[i].split(" ");
            String collectDate = splitPrivacy[0]; 
            String termType = splitPrivacy[1];    
            
            int collectDays = convertToDays(collectDate);
            
            int validityDays = termMap.get(termType) * 28;
            
            if (collectDays + validityDays <= todayDays) {
                expiredList.add(i + 1);
            }
        }
        
        int[] answer = new int[expiredList.size()];
        for (int i = 0; i < expiredList.size(); i++) {
            answer[i] = expiredList.get(i);
        }
        
        return answer;
    }
    
    private int convertToDays(String dateStr) {
        String[] splitDate = dateStr.split("\\.");
        int year = Integer.parseInt(splitDate[0]);
        int month = Integer.parseInt(splitDate[1]);
        int day = Integer.parseInt(splitDate[2]);
        
        return (year * 12 * 28) + (month * 28) + day;
    }
}