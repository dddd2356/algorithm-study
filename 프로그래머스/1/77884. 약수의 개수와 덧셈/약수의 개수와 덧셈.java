import java.util.*;

class Solution {
    public static List<Integer> getDivisors(int n) {
        List<Integer> divisors = new ArrayList<>();
        
        // 1부터 N의 제곱근까지만 반복합니다.
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                divisors.add(i); // 작은 약수 추가
                
                // 제곱근으로 딱 떨어지는 중복 값이 아니라면, 짝이 되는 큰 약수도 추가
                if (i != n / i) {
                    divisors.add(n / i);
                }
            }
        }
        
        // 약수들을 오름차순으로 정렬합니다.
        Collections.sort(divisors);
        return divisors;
    }
    
    public int solution(int left, int right) {
        int answer = 0;
        for(int i=left; i<=right; i++){
            int count = getDivisors(i).size();
            if(count%2==0){
                answer+=i;
            }
            else{
                answer-=i;
            }
        }
        return answer;
    }
}

