class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int textArea = brown + yellow;
        
        for(int height=3; height<textArea; height++){
            
            if(textArea % height == 0){
                int width = textArea / height;
                
                if((width-2) * (height-2) == yellow){
                    answer[0] = width;
                    answer[1] = height;
                    break;
                }
            }
        }
        
        return answer;
    }
}