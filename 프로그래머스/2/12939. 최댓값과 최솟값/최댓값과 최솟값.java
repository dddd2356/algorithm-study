class Solution {
    public String solution(String s) {
        String answer = "";
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        String[] splitS = s.split(" ");
        
        for(int i=0; i<splitS.length; i++){
            if(Integer.parseInt(splitS[i]) > max){
                max = Integer.parseInt(splitS[i]);  
            }
            
            if(Integer.parseInt(splitS[i]) < min){
                min = Integer.parseInt(splitS[i]);
            }
        }
        answer = min + " " + max;
        return answer;
    }
}