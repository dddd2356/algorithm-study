import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int minRow = 999; 
        int minCol = 999; 
        int maxRow = 0;  
        int maxCol = 0;  
        
       
        for (int i = 0; i < wallpaper.length; i++) { 
            for (int j = 0; j < wallpaper[i].length(); j++) { 
                
                if (wallpaper[i].charAt(j) == '#') {
                    if (i < minRow) minRow = i;
                    if (i > maxRow) maxRow = i;
                    
                    if (j < minCol) minCol = j;
                    if (j > maxCol) maxCol = j;
                }
                
            }    
        }
        
        int[] answer = {minRow, minCol, maxRow + 1, maxCol + 1};
        return answer; 
    }
}