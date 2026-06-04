class Solution {
    public int[] solution(String[] park, String[] routes) {
        int H = park.length;       
        int W = park[0].length();  
        
        int x = 0;
        int y = 0;
        
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (park[i].charAt(j) == 'S') {
                    y = i;
                    x = j;
                    break;
                }
            }
        }
        
       for (String route : routes) {
            String[] split = route.split(" ");
            String dir = split[0];
            int steps = Integer.parseInt(split[1]);
                 
            int nx = x;
            int ny = y;
            boolean isPossible = true;
            
            for (int i = 0; i < steps; i++) {
                if (dir.equals("E")) nx++;
                else if (dir.equals("W")) nx--;
                else if (dir.equals("S")) ny++;
                else if (dir.equals("N")) ny--;
                
                if (nx < 0 || nx >= W || ny < 0 || ny >= H || park[ny].charAt(nx) == 'X') {
                    isPossible = false;
                    break;
                }
            }
        
            if (isPossible) {
                x = nx;
                y = ny;
            }
        }
        
        return new int[]{y, x};
    }
}