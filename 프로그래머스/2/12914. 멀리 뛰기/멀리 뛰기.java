class Solution {
    public long solution(int n) {
        if(n<=2){
            return n;
        }
        
        long answer1 = 1;
        long answer2 = 2; 
        
        for(int i=3; i<n+1; i++){
            long current = (answer1 + answer2)%1234567;
            answer1 = answer2;
            answer2 = current;
        }
        
        return answer2;
    }
}