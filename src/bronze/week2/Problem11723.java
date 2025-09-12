package bronze.week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Problem11723 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if (cmd.equals("add")) {
                set.add(Integer.parseInt(st.nextToken()));
            } else if (cmd.equals("remove")) {
                set.remove(Integer.parseInt(st.nextToken()));
            } else if (cmd.equals("check")) {
                sb.append(set.contains(Integer.parseInt(st.nextToken())) ? "1\n" : "0\n");
            } else if (cmd.equals("toggle")) {
                int x = Integer.parseInt(st.nextToken());
                if (!set.remove(x)) set.add(x);
            } else if (cmd.equals("all")) {
                set.clear();
                for (int j = 1; j <= 20; j++) set.add(j);
            } else if (cmd.equals("empty")) {
                set.clear();
            }
        }

        System.out.print(sb.toString());
    }
}