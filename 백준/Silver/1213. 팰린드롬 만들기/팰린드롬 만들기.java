import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int[] cnt = new int[26];

        // 개수 세기
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'A']++;
        }

        // 홀수 체크
        int oddCount = 0;
        int oddIndex = -1;

        for (int i = 0; i < 26; i++) {
            if (cnt[i] % 2 == 1) {
                oddCount++;
                oddIndex = i;
            }
        }

        if (oddCount > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        // 왼쪽 만들기
        StringBuilder left = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < cnt[i] / 2; j++) {
                left.append((char) ('A' + i));
            }
        }

        // 결과 만들기
        StringBuilder result = new StringBuilder();
        result.append(left);

        // 가운데 (홀수 있으면)
        if (oddIndex != -1) {
            result.append((char) ('A' + oddIndex));
        }

        // 오른쪽 (뒤집기)
        result.append(left.reverse());

        System.out.println(result);
    }
}