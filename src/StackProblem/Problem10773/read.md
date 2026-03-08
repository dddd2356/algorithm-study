# 백준 10773 - 제로

## 문제 요약

- 양수 입력 → 기록
- 0 입력 → 가장 최근에 기록한 수 취소
- 마지막에 남은 수의 합 출력

---

## 핵심 자료구조: Stack

**Stack은 LIFO (Last In First Out)** - 마지막에 들어온 것이 먼저 나간다.

```
push(3) → [3]
push(5) → [3, 5]
push(1) → [3, 5, 1]
pop()   → [3, 5]     꺼낸 값: 1 (마지막에 넣은 것)
pop()   → [3]        꺼낸 값: 5
```

"가장 최근에 기록한 수를 취소" = **마지막에 넣은 것을 꺼내기** → Stack이 딱 맞는 구조.

---

## 핵심 동작

```java
if(b == 0){
    stack.pop();   // 가장 최근 수 취소
} else {
    stack.push(b); // 수 기록
}
```

---

## 전체 흐름 예시

입력: `4 3 0 5`  (K=4, 입력값: 3, 0, 5)

```
입력: 3  → push(3)  스택: [3]
입력: 0  → pop()    스택: []     (3 취소)
입력: 5  → push(5)  스택: [5]
입력: 4  → push(4)  스택: [5, 4]

합: 5 + 4 = 9
```

---

## 코드 리뷰

```java
Stack<Integer> stack = new Stack<>();
int a = sc.nextInt();
int result = 0;
for(int i=0; i<a; i++){
    int b = sc.nextInt();
    if(b==0){
        stack.pop();   // 0이면 최근 수 취소 ✓
    }
    else
        stack.push(b); // 양수면 기록 ✓
}
while(!stack.isEmpty()){
    result = result + stack.pop(); // 남은 수 모두 합산 ✓
}
System.out.println(result);
```

### 잘된 점

- Stack의 LIFO 특성을 정확히 활용 ✓
- 0 입력 시 pop, 양수 입력 시 push로 명확히 분리 ✓

### 개선 가능한 점

**1. Stack 대신 ArrayDeque 권장**

Java의 `Stack`은 내부적으로 `Vector`를 상속해 느리다.
`ArrayDeque`를 사용하면 더 빠르다.

```java
Deque<Integer> stack = new ArrayDeque<>();
stack.push(b);   // 삽입
stack.pop();     // 제거
```

**2. 합산을 반복문 안에서 처리 가능**

```java
// pop하면서 따로 합산하는 while문 없이
// 스택에서 꺼낼 때 바로 합산해도 됨
for(int i=0; i<a; i++){
    int b = sc.nextInt();
    if(b == 0) stack.pop();
    else stack.push(b);
}
int result = 0;
for(int n : stack) result += n; // 향상된 for문으로 합산
```

---

## Stack vs Queue vs PriorityQueue

| 자료구조 | 구조 | 꺼내는 기준 | 사용 상황 |
|---------|------|-----------|---------|
| Stack | LIFO | 마지막에 넣은 것 | 되돌리기, 괄호 검사 |
| Queue | FIFO | 먼저 넣은 것 | 순서 유지, 순환 시뮬레이션 |
| PriorityQueue | Heap | 우선순위 높은 것 | 최솟값/최댓값 반복 추출 |
