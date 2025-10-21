package swea;

import java.util.Scanner;

public class Problem1989 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 수 입력

        // 여러 개의 테스트 케이스를 처리
        for (int test_case = 1; test_case <= T; test_case++) {

            String s = sc.next();  // 단어 입력 (공백 기준)
            boolean isSame = true; // 회문인지 판별할 변수 (처음엔 true)
            int len = s.length();  // 문자열 길이

            // 문자열의 앞과 뒤를 비교 (절반까지만)
            for (int j = 0; j < len / 2; j++) {
                // 앞 문자와 뒤 문자가 다르면 회문 아님
                if (s.charAt(j) != s.charAt(len - 1 - j)) {
                    isSame = false;
                    break; // 한 번이라도 다르면 바로 중단
                }
            }

            // 결과 출력 (SWEA 형식: #테스트케이스번호 결과)
            System.out.println("#" + test_case + " " + (isSame ? 1 : 0));
        }

        sc.close(); // Scanner 종료
    }
}

