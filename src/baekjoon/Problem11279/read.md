# 백준 11279 - 최대 힙

## 문제 요약

- 입력 N개: 각 줄에 정수 x
  - x > 0 : 배열에 x를 넣기
  - x = 0 : 배열에서 **가장 큰 값** 출력 후 제거 (비어있으면 0 출력)

---

## 자료구조 개념

### 힙 (Heap)

완전 이진 트리 기반의 자료구조. 두 종류가 있다.

| 종류 | 특징 | 루트 노드 |
|------|------|----------|
| 최소 힙 (Min Heap) | 부모 <= 자식 | 항상 최솟값 |
| 최대 힙 (Max Heap) | 부모 >= 자식 | 항상 최댓값 |

```
최대 힙 예시:
        9
       / \
      7   5
     / \
    3   2
```

- 삽입: 맨 끝에 넣고 부모와 비교하며 위로 올림 → O(log N)
- 꺼내기: 루트를 꺼내고 재정렬 → O(log N)
- 최댓값 조회: 루트만 보면 됨 → O(1)

### PriorityQueue (우선순위 큐)

Java에서 힙을 구현한 클래스. **기본값은 최소 힙**.

```java
PriorityQueue<Integer> minPq = new PriorityQueue<>(); // 최소 힙 (기본)
```

내부적으로 배열로 힙을 구현하며, `poll()`할 때마다 우선순위가 가장 높은 값을 꺼낸다.

### Comparator.reverseOrder()

기본 정렬 순서를 **반대로** 뒤집는 Comparator.
Integer의 기본 순서는 오름차순(작은 것이 우선)이므로,
`reverseOrder()`를 쓰면 내림차순(큰 것이 우선) → **최대 힙** 완성.

```java
// 최대 힙 만드는 방법 3가지 (모두 동일)
PriorityQueue<Integer> pq1 = new PriorityQueue<>(Comparator.reverseOrder());
PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
PriorityQueue<Integer> pq3 = new PriorityQueue<>((a, b) -> b - a); // 람다
```

---

## 코드 개선 과정

### 1단계: 처음 작성 코드 (배열 + sort)

```java
int[] num = new int[x-1]; // 버그1: 크기가 x-1 → IndexOutOfBoundsException
for(int i=0; i<x; i++){
    num[i]=sc.nextInt();
    if(num[i]==0){
        num[i]=-1;
        Arrays.sort(num); // 버그2: 매번 O(N log N) → 전체 O(N² log N) 시간초과
        // 버그3: 0을 제거하는 게 아니라 -1로 바꿔 배열에 남김 → 로직 오류
    }
}
```

### 2단계: PriorityQueue 도입 후 코드

```java
PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
for(int i=0; i<x; i++){
    int a = sc.nextInt();
    pq.add(a);       // 버그: a==0일 때도 0을 힙에 넣음
    if(a==0){
        pq.poll();   // 0이 힙에 남아서 나중에 최댓값으로 잘못 출력될 수 있음
    }
}
```

**왜 틀리나?** `pq.add(a)`가 먼저 실행되어 0이 힙에 쌓임.
연산이 반복될수록 힙 안에 0이 누적 → 언젠가 0이 최댓값처럼 출력됨.

### 3단계: 최종 올바른 코드

```java
PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
for(int i=0; i<x; i++){
    int a = sc.nextInt();
    if(a == 0){
        // 0은 힙에 넣지 않고, 꺼내기만 함
        System.out.println(pq.isEmpty() ? 0 : pq.poll());
    } else {
        pq.add(a); // 양수만 삽입
    }
}
```

**핵심 개선:** `if/else`로 분리해서 0은 절대 힙에 들어가지 않도록 보장.

---

## 정리

| 상황 | 해야 할 일 |
|------|-----------|
| x > 0 | pq.add(x) |
| x = 0, pq 비어있음 | 0 출력 |
| x = 0, pq 있음 | pq.poll() 출력 (자동으로 최댓값) |

> 입출력이 많으면 `BufferedReader` + `StringBuilder` 조합으로 성능 개선 가능.
