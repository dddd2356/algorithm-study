package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem11005 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken()); // 입력 N (0 이상)
        int B = Integer.parseInt(st.nextToken()); // 진법 2~36

        if (N == 0) {
            System.out.println("0");
            return;
        }

        StringBuilder sb = new StringBuilder();
        while (N > 0) {
            int rem = (int) (N % B);
            if (rem < 10) {
                sb.append((char) ('0' + rem));
            } else {
                sb.append((char) ('A' + (rem - 10)));
            }
            N /= B;
        }

        System.out.println(sb.reverse().toString());
    }

}