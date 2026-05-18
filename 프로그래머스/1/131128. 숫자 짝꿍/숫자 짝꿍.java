class Solution {
    public String solution(String X, String Y) {
        // 1. X와 Y에 등장하는 숫자(0~9)의 개수를 저장할 빈도수 배열 생성
        int[] countX = new int[10];
        int[] countY = new int[10];
        
        // 2. X의 각 숫자 개수 세기
        for(int i = 0; i < X.length(); i++){
            countX[X.charAt(i) - '0']++; // 문자를 숫자로 변환하여 인덱스에 누적
        }
        
        // 3. Y의 각 숫자 개수 세기
        for(int i = 0; i < Y.length(); i++){
            countY[Y.charAt(i) - '0']++;
        }
        
        // 4. 공통으로 존재하는 숫자를 큰 수(9)부터 0까지 모으기
        // String 더하기 연산은 느리므로 StringBuilder를 사용합니다.
        StringBuilder sb = new StringBuilder();
        
        for(int i = 9; i >= 0; i--) {
            // 두 문자열 중 더 적게 나타난 횟수만큼 공통으로 겹치는 것임
            int common = Math.min(countX[i], countY[i]);
            
            for(int j = 0; j < common; j++) {
                sb.append(i);
            }
        }
        
        // 5. 예외 조건 처리 (숫자 짝꿍 문제의 필수 조건)
        // 짝꿍이 없는 경우
        if(sb.length() == 0) {
            return "-1";
        }
        // 짝꿍이 0으로만 이루어진 경우 (예: "000" -> "0")
        if(sb.charAt(0) == '0') {
            return "0";
        }
        
        return sb.toString();
    }
}