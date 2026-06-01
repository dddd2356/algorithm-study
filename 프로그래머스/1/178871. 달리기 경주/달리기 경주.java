import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i< players.length; i++){
            map.put(players[i], i);
        }
        
        for (int i = 0; i < callings.length; i++) { 
            String calledPlayer = callings[i]; 
            
            int currentRank = map.get(calledPlayer); 
            
            int frontRank = currentRank - 1;
            String frontPlayer = players[frontRank];
            
            players[frontRank] = calledPlayer;
            players[currentRank] = frontPlayer;
            
            map.put(calledPlayer, frontRank);
            map.put(frontPlayer, currentRank);
        }
        
        return players;
    }
}