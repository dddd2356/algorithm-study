import java.util.*;

class Solution {
    public long solution(long n) {
        String num = Long.toString(n);
        
        String[] result = num.split("");
        
        Arrays.sort(result, Collections.reverseOrder());
    
        String sb = "";
        for (String s : result) {
            sb += s;
        }
        
        return Long.parseLong(sb);
    }
}