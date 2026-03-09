package HashMapProblem.Problem2002;

import java.util.HashMap;
import java.util.Scanner;

public class Problem2002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        HashMap<String, Integer> mapA = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String s = sc.nextLine();
            mapA.put(s, i);
        }

        String[] arrayB = new String[N];
        for (int i = 0; i < N; i++) {
            String s = sc.nextLine();
            arrayB[i] = s;  // B 순서대로 배열에 저장
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            int orderA_i = mapA.get(arrayB[i]);
            for (int j = i + 1; j < N; j++) {
                int orderA_j = mapA.get(arrayB[j]);
                if (orderA_j < orderA_i) {  // 뒤에 나왔는데 A순서가 앞
                    result++;
                    break;  // 하나라도 있으면 추월한 것
                }
            }
        }
        System.out.println(result);
    }
}
