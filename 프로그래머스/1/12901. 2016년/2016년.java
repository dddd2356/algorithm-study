class Solution {
     public String solution(int a, int b) {
        int[] days = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] week = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        
        int total = 0;
        for (int i = 0; i < a - 1; i++) {
            total += days[i];
        }
        total += b;
        
        return week[(total - 1 + 5) % 7];
    }
}