class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i); 
            int moved = 0;          
            
            while (moved < index) {
                curr++; 
                
                if (curr > 'z') { 
                    curr = 'a';
                }
                
                if (skip.contains(String.valueOf(curr))) {
                    continue; 
                }
                
                moved++;
            }
            
            answer.append(curr);
        }
        
        return answer.toString();
    }
}