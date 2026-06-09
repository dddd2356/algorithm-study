import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        if (arr.length <= 1) {
            return new int[]{-1};
        }
        int min = Integer.MAX_VALUE;
        int count = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            list.add(arr[i]);
            if(min>arr[i]){
                min = arr[i];
                count = i;
            }
        }
        
        list.remove(count);
        
        int[] answer = new int[list.size()];
        if(list.size()!=1){
            for(int i=0; i<list.size(); i++){
                answer[i] = list.get(i);
            }
        }
    
        return answer;
    }
}