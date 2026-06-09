import java.util.*;
class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        boolean[] isExist = new boolean[10];
        
        for (int num : numbers) {
            isExist[num] = true;
        }
        
        for (int i = 0; i < 10; i++) {
            if (!isExist[i]) {
                answer += i;
            }
        }
        
        return answer;
    }
}