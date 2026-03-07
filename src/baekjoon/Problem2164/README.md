# Problem 2164 - 카드2

[백준 2164번](https://www.acmicpc.net/problem/2164)

## 풀이 요약

큐를 이용해 카드를 시뮬레이션. 맨 위 카드를 버리고, 다음 카드를 맨 뒤로 보내는 과정을 반복.

## 코드 리뷰

### 잘된 점

- Queue를 활용한 직관적이고 정확한 시뮬레이션 구현
- 코드가 간결하고 읽기 쉬움

### ArrayDeque 사용 권장

```java
Queue<Integer> queue = new LinkedList<>(); // 노드 기반, 메모리 오버헤드 있음
```

`ArrayDeque`는 배열 기반으로 `LinkedList`보다 빠르다.

```java
Queue<Integer> queue = new ArrayDeque<>();
```

### 수학적 풀이

N이 최대 500,000이므로 시뮬레이션이 허용되지만, 수학적으로 N 이하의 2의 거듭제곱 중 가장 큰 값을 구하면 O(log N)으로 해결 가능하다.

```java
int p = 1;
while (p * 2 <= N) p *= 2;
System.out.println(2 * (N - p));
```
