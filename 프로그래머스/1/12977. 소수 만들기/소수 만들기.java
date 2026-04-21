class Solution {
    public int solution(int[] nums) {
        int cnt = 0;
        for(int i=0; i<nums.length-2; i++){
            for(int j=i+1; j<nums.length-1;j++){
                for(int z = j+1; z<nums.length; z++){
                    if(isPrime(nums[i]+nums[j]+nums[z])){
                    cnt++;    
                    }
                }
            }
        }
        
        return cnt;
    }
    
    public static boolean isPrime(int n) {
    if (n < 2) return false;
    // n의 제곱근까지만 반복
    for (int i = 2; i <= Math.sqrt(n); i++) {
        if (n % i == 0) return false; // 약수가 존재하면 소수 아님
    }
    return true;
}
}