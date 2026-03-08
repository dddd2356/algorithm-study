# 백준 11279 - 최대 힙

## 문제 요약

- 입력 N개: 각 줄에 정수 x
  - x > 0 : 배열에 x를 넣기
  - x = 0 : 배열에서 **가장 큰 값** 출력 후 제거 (비어있으면 0 출력)

## 핵심 자료구조: 최대 힙 (Max Heap)

**최대 힙**은 항상 가장 큰 값을 O(1)에 꺼낼 수 있는 완전 이진 트리 구조.
- 삽입: O(log N)
- 최댓값 꺼내기: O(log N)

Arrays.sort를 매번 쓰면 O(N log N)이 N번 → 총 O(N² log N)으로 **시간초과**.

## Java 풀이 방향

Java의 `PriorityQueue`는 기본이 **최소 힙**.
최대 힙으로 만들려면 `Collections.reverseOrder()` 또는 람다 `(a, b) -> b - a` 사용.

```java
import java.util.*;

PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

// 삽입
pq.offer(x);

// 최댓값 꺼내기
if (pq.isEmpty()) System.out.println(0);
else System.out.println(pq.poll());
```

## 현재 코드의 문제점

1. `int[] num = new int[x-1]` → 크기가 1 부족 (ArrayIndexOutOfBoundsException)
2. 0 입력 시 로직이 너무 복잡하고 틀림 (직접 Arrays.sort 매번 호출)
3. 0 자체를 배열에 넣는 것도 문제

## 풀이 골격

```java
import java.util.*;
import java.io.*;

public class Problem11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                sb.append(pq.isEmpty() ? 0 : pq.poll()).append('\n');
            } else {
                pq.offer(x);
            }
        }
        System.out.print(sb);
    }
}
```

## 정리

| 상황 | 해야 할 일 |
|------|-----------|
| x > 0 | pq.offer(x) |
| x = 0, pq 비어있음 | 0 출력 |
| x = 0, pq 있음 | pq.poll() 출력 (자동으로 최댓값) |

> 입출력이 많으니 `BufferedReader` + `StringBuilder` 사용 권장.
