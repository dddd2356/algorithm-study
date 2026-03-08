# 백준 2075 - N번째 큰 수

## 문제 요약

- N×N 크기의 표가 주어짐
- 전체 N² 개의 수 중 **N번째로 큰 수** 출력

---

## Queue vs PriorityQueue

일반 Queue는 **FIFO** (먼저 들어온 것이 먼저 나감).
PriorityQueue는 이름만 Queue일 뿐, **내부 구조는 힙(Heap)**.
들어온 순서가 아니라 **우선순위 기준**으로 꺼낸다.

```
일반 Queue: add(1, 3, 2) → poll 순서: 1 → 3 → 2  (입력 순서)
PriorityQueue: add(1, 3, 2) → poll 순서: 1 → 2 → 3  (크기 순서)
```

---

## 우선순위란?

PriorityQueue는 **우선순위가 높은 것**이 먼저 나간다.
기본값에서는 **작은 값 = 우선순위 높음** → 작은 것부터 나감.

Comparator로 우선순위 기준을 바꿀 수 있다:

```java
// 기본: 작은 값이 우선순위 높음 → 작은 것부터 나감
PriorityQueue<Integer> minPq = new PriorityQueue<>();

// 큰 값이 우선순위 높음 → 큰 것부터 나감
PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());

// 절댓값 작은 값이 우선순위 높음
PriorityQueue<Integer> absPq = new PriorityQueue<>((a, b) -> Math.abs(a) - Math.abs(b));
```

지금까지 푼 문제 정리:

| 문제 | 우선순위 기준 |
|------|-------------|
| 1927 (최소 힙) | 작은 값 = 우선순위 높음 |
| 11279 (최대 힙) | 큰 값 = 우선순위 높음 |
| 11286 (절댓값 힙) | 절댓값 작은 값 = 우선순위 높음 |
| 2075 (N번째 큰 수) | 작은 값 = 우선순위 높음 (작은 것을 버리기 위해) |

---

## 왜 PriorityQueue를 쓰나?

**메모리 제한: 12MB**

1D 배열로 N²개 전부 저장 시:
- N=1500 → 1500² = 2,250,000개 → 약 9MB → **메모리 초과 위험**

PriorityQueue로 N개만 유지:
- 최대 1500개만 저장 → 안전

---

## 핵심 아이디어

최소 힙에 N개만 유지하면서 읽으면, 마지막에 힙 안에는 **전체에서 가장 큰 N개**만 남는다.
그 중 가장 작은 값(루트) = **N번째로 큰 수**.

```
N=3, 숫자를 하나씩 읽으며 힙 크기를 3으로 유지:

읽은 값  힙 상태            동작
  12   → [12]              추가
   7   → [7, 12]           추가
   9   → [7, 9, 12]        추가
   3   → [7, 9, 12]        3 추가 → 크기 4 → 최솟값 3 제거
  15   → [9, 12, 15]       15 추가 → 크기 4 → 최솟값 7 제거
   6   → [9, 12, 15]       6 추가 → 크기 4 → 최솟값 6 제거
  10   → [10, 12, 15]      10 추가 → 크기 4 → 최솟값 9 제거
   2   → [10, 12, 15]      2 추가 → 크기 4 → 최솟값 2 제거
   8   → [10, 12, 15]      8 추가 → 크기 4 → 최솟값 8 제거

pq.peek() = 10 → 3번째로 큰 수 ✓
```

작은 것을 계속 버리면 → 결국 **큰 것 N개만 남음** → 그 중 최솟값이 N번째로 큰 수.

---

## 코드

```java
PriorityQueue<Integer> pq = new PriorityQueue<>();
Scanner sc = new Scanner(System.in);
int N = sc.nextInt();

for(int i=0; i<N; i++){
    for(int j=0; j<N; j++){
        int a = sc.nextInt();
        pq.add(a);
        if(pq.size() > N)
            pq.poll(); // 가장 작은 값 제거 → N개 유지
    }
}
System.out.println(pq.peek()); // 힙의 루트 = N번째로 큰 수
```

---

## 초기 코드 문제점

```java
int[][] A = new int[N-1][N-1]; // 버그1: 크기 N-1 → IndexOutOfBoundsException
Arrays.sort(A);                 // 버그2: 2D 배열 sort 불가 → ClassCastException
System.out.println(A[0][N-1]); // 버그3: 행별 정렬은 전체 순서 반영 안 됨
```

---

## 두 방식 비교

| | 1D 배열 + sort | PriorityQueue |
|--|---------------|---------------|
| 메모리 | N² 개 저장 (위험) | N개만 저장 (안전) |
| 시간복잡도 | O(N² log N²) | O(N² log N) |
| 구현 난이도 | 쉬움 | 보통 |
