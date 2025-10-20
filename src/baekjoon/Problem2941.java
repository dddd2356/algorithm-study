package baekjoon;

import java.util.Scanner;

public class Problem2941 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int count = findAlphabet(s);
        System.out.println(count);
    }

    private static int findAlphabet(String s) {
        int count = 0;
        int i = 0;

        while (i < s.length()) {
            // 안전하게 인덱스 체크
            if (i + 1 < s.length()) {
                if (s.charAt(i) == 'c' && (s.charAt(i + 1) == '=' || s.charAt(i + 1) == '-')) {
                    count++;
                    i += 2;
                    continue;
                }
                if (s.charAt(i) == 'd') {
                    if (i + 2 < s.length() && s.charAt(i + 1) == 'z' && s.charAt(i + 2) == '=') {
                        count++;
                        i += 3;
                        continue;
                    } else if (s.charAt(i + 1) == '-') {
                        count++;
                        i += 2;
                        continue;
                    }
                }
                if ((s.charAt(i) == 'l' || s.charAt(i) == 'n') && s.charAt(i + 1) == 'j') {
                    count++;
                    i += 2;
                    continue;
                }
                if ((s.charAt(i) == 's' || s.charAt(i) == 'z') && s.charAt(i + 1) == '=') {
                    count++;
                    i += 2;
                    continue;
                }
            }

            // 위에 해당하지 않으면 그냥 한 글자
            count++;
            i++;
        }

        return count;
    }
}
