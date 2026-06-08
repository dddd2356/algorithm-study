class Solution {
    public int solution(int n) {
        return pivonachi(n);
    }
    
    public int pivonachi(int num){
        int[] sum = new int[num+1];
        sum[0] = 0;
        sum[1] = 1;
        
        if(num>2){
            for(int i=2; i<num+1; i++){
                sum[i] = (sum[i-1] + sum[i-2]) % 1234567;
            }
        }   

        return sum[num];
    }
}