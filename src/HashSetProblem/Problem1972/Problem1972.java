package HashSetProblem.Problem1972;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Problem1972 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null && !line.equals("*")) {
            System.out.println(line + " is" + (isSurprising(line) ? "" : " NOT") + " surprising.");
        }
    }

    static boolean isSurprising(String s) {
        // 간격 i = 1부터 len-1까지 검사
        // 예) "AABB"에서 i=1이면 (A,A),(A,B),(B,B) 쌍 검사
        for (int i = 1; i < s.length(); i++) {
            HashSet<String> set = new HashSet<>();
            // j: 시작 인덱스, j+i: 끝 인덱스 (범위 초과 방지)
            for (int j = 0; j + i < s.length(); j++) {
                // 간격 i인 두 문자를 하나의 쌍 문자열로 만들기
                // 예) s="AABB", i=1, j=0 → pair="AA"
                String pair = "" + s.charAt(j) + s.charAt(j + i);
                // set에 추가 실패 = 이미 같은 쌍이 존재 → 놀라운 문자열 아님
                if (!set.add(pair)) return false;
            }
        }
        // 모든 간격에서 중복 쌍 없음 → 놀라운 문자열
        return true;
    }
}
