import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[n];
        Stack<int[]> stack = new Stack<>(); // {높이, 인덱스(1-based)}

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek()[0] < A[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? 0 : stack.peek()[1];
            stack.push(new int[]{A[i], i + 1});
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(result[i]);
            if (i < n - 1) sb.append(" ");
        }
        System.out.println(sb);
    }
}