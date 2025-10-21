package swea;

import java.util.Scanner;

public class Problem2007 {

        public static void main(String[] args) throws Exception {
            Scanner sc = new Scanner(System.in);
            int T = sc.nextInt();  // 테스트 케이스 수 입력
            sc.nextLine();         // 개행 문자 제거

            for (int test_case = 1; test_case <= T; test_case++) {
                String str = sc.nextLine().trim(); // 문자열 입력
                int result = findPatternLength(str); // 패턴 길이 계산
                System.out.println("#" + test_case + " " + result);
            }

            sc.close();
        }

        // 패턴 마디 길이 찾기
        public static int findPatternLength(String s) {
            int n = s.length();

            // 가능한 패턴 길이 탐색
            for (int k = 1; k <= n / 2; k++) {
                boolean match = true;
                for (int i = 0; i < k; i++) {
                    if (s.charAt(i) != s.charAt(i + k)) {
                        match = false;
                        break;
                    }
                }
                if (match) return k; // 패턴 발견 시 반환
            }

            return n; // 반복되는 패턴이 없으면 전체 길이 반환
        }

}
