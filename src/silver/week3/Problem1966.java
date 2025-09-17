package silver.week3;

import java.util.LinkedList;
import java.util.Scanner;

//그냥 사용하는 것이 아닌 배열로 저장하여서 순서를 저장할 수 있게끔해야함. 그냥 저장하면 중복된 수에서 문제를 일으킬 수 있음.
public class Problem1966 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            int N = sc.nextInt(); // 문서 개수
            int M = sc.nextInt(); // 궁금한 문서 위치
            LinkedList<int[]> queue = new LinkedList<>(); // {priority, originalIndex}

            // 큐에 값과 인덱스 함께 넣기
            for (int i = 0; i < N; i++) {
                int priority = sc.nextInt();
                queue.addLast(new int[]{priority, i});
            }

            int count = 0;

            while (!queue.isEmpty()) {
                int[] current = queue.pollFirst(); // 맨 앞 문서 꺼내기
                boolean hasHigher = false;

                // 현재 문서보다 우선순위 높은 문서가 있는지 확인
                for (int[] doc : queue) {
                    if (doc[0] > current[0]) {
                        hasHigher = true;
                        break;
                    }
                }

                if (hasHigher) {
                    // 우선순위 높은 문서가 있으면 뒤로 보내기
                    queue.addLast(current);
                } else {
                    // 인쇄
                    count++;
                    if (current[1] == M) { // 궁금한 문서이면 종료
                        System.out.println(count);
                        break;
                    }
                }
            }
        }
    }
}