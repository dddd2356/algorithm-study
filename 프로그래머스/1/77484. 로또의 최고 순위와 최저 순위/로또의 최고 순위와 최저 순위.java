import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int[] rank = {6, 6, 5, 4, 3, 2, 1};
        int collectNums = 0;
        int zero =0;
        for(int i=0; i<lottos.length; i++){
             if(lottos[i]==0){
                    zero++;
                    continue;
                }
            for(int j=0; j<win_nums.length; j++){
               
                if(lottos[i]==win_nums[j]){
                    collectNums++;
                }
            }
        }
        
        answer[0] = rank[collectNums + zero];
        answer[1] = rank[collectNums];
        
        return answer;
    }
}