package bronze.week2;

import java.util.*;

public class Problem10816{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 1. 첫 번째 입력: N (arr1의 크기)
        int N = sc.nextInt();

        // 2. N개의 수를 HashSet에 저장
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 3. 두 번째 입력: M (arr2의 크기)
        int M = sc.nextInt();
        // 4. M개의 수를 하나씩 읽으면서 set에 있는지 확인
        StringBuilder sb = new StringBuilder();

        // M개의 숫자 입력 → map에서 개수 조회
        for (int i = 0; i < M; i++) {
            int target = sc.nextInt();
            sb.append(map.getOrDefault(target, 0)).append(" ");
        }
        System.out.println(sb);
    }
}