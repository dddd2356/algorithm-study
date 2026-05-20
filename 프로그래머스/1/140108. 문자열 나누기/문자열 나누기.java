class Solution {
    public int solution(String s) {
        int answer = 0;
        int count1 = 0;
        int count2 = 0;
        char[] word = new char[s.length()];
        word = s.toCharArray();
        char first_word = ' ';
        for(int i=0; i<word.length; i++){
            if(count1==0 && count2 ==0){
                first_word = word[i];
            }
            
            if (first_word == word[i]) {
                count1++;
            } 
            else {
                count2++;
            }
            
            if (count1 == count2) {
                answer++;
                count1 = 0;
                count2 = 0;
            }
        }
        
        if (count1 != 0 || count2 != 0) {
            answer++;
        }
        
        return answer;
    }
}