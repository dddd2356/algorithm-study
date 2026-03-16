package Simulation.Prboblem2504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Problem2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();
        // 스택으로 괄호의 짝을 검사
        Stack<Character> stack = new Stack<>();
        int result = 0;       // 최종 값
        int mul = 1;          // 현재 누적 곱 (중첩된 괄호의 곱을 유지)

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(c);
                mul *= 2;   // '(' 가 열리면 앞으로 닫힐 때 곱해질 값에 2 추가
            } else if (c == '[') {
                stack.push(c);
                mul *= 3;   // '[' 는 3
            } else if (c == ')') {
                // 올바른 짝인지 확인
                if (stack.isEmpty() || stack.peek() != '(') {
                    System.out.println(0);
                    return;
                }
                // 바로 앞 문자가 '(' 라면 이 괄호쌍이 '값을 직접 더하는' 케이스
                // 예: "()" 이거나 "... ( ) ..." 에서 내부가 이미 처리된 경우가 아님
                if (s.charAt(i - 1) == '(') {
                    result += mul;
                }
                stack.pop();
                mul /= 2;  // '(' 가 닫혔으니 더 이상 2를 곱해주지 않음
            } else if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    System.out.println(0);
                    return;
                }
                if (s.charAt(i - 1) == '[') {
                    result += mul;
                }
                stack.pop();
                mul /= 3;
            } else {
                // 허용되지 않는 문자
                System.out.println(0);
                return;
            }
        }

        // 모든 괄호가 짝을 이루어야 함
        if (!stack.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(result);
        }
    }
}