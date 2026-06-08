class Solution {
    public int solution(int num1, int num2) {
        int answer = 0;
        double sum = ((double)num1/num2)*1000.0;
        answer = (int)sum; 
        return answer;
    }
}