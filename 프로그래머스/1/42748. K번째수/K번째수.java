import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length]; 

        for(int i = 0; i < commands.length; i++){
            int first = commands[i][0];  
            int last = commands[i][1];  
            int result = commands[i][2]; 

            int[] nArray = new int[last - first + 1];
            for(int j = 0; j < nArray.length; j++){
                nArray[j] = array[first + j - 1]; 
            }

            Arrays.sort(nArray); 
            answer[i] = nArray[result - 1]; 
        }
        return answer;
    }
}