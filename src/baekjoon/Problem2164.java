package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem2164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < N + 1; i++) {
            queue.add(i);
        }

        while (queue.size() > 1) {
            queue.remove();           // 버림
            queue.add(queue.remove()); // 다음 카드 맨 뒤로
        }
        System.out.println(queue.peek());
    }
}
