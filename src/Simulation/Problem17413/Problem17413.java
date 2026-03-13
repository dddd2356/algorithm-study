package Simulation.Problem17413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        StringBuilder ans = new StringBuilder();
        StringBuilder buffer = new StringBuilder(); // 단어를 모아서 뒤집을 버퍼
        boolean inTag = false;

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);

            if (c == '<') {
                // 태그 시작: 현재 버퍼(단어)가 있으면 뒤집어 출력 후 버퍼 비우기
                if (buffer.length() > 0) {
                    ans.append(buffer.reverse());
                    buffer.setLength(0);
                }
                inTag = true;
                ans.append(c); // '<' 포함해서 태그 그대로 추가
            } else if (c == '>') {
                inTag = false;
                ans.append(c); // '>' 추가
            } else if (inTag) {
                // 태그 내부는 있는 그대로 추가
                ans.append(c);
            } else {
                // 태그 밖: 단어 처리 (공백이면 지금까지 버퍼 뒤집어 출력하고 공백 출력)
                if (c == ' ') {
                    if (buffer.length() > 0) {
                        ans.append(buffer.reverse());
                        buffer.setLength(0);
                    }
                    ans.append(' ');
                } else {
                    // 단어 문자이면 버퍼에 쌓음
                    buffer.append(c);
                }
            }
        }

        // 마지막에 버퍼에 남은 단어가 있으면 뒤집어 출력
        if (buffer.length() > 0) {
            ans.append(buffer.reverse());
        }

        System.out.println(ans);
    }
}