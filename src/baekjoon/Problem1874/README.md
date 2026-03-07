# Problem 1874 - 스택 수열

[백준 1874번](https://www.acmicpc.net/problem/1874)

## 풀이 요약

1부터 N까지 순서대로 스택에 push하면서, 목표 수열을 만들 수 있는지 판별.
불가능하면 "NO", 가능하면 push/pop 순서를 출력.

## 코드 리뷰

### 잘된 점

- 스택 수열 알고리즘을 올바르게 구현
- `StringBuffer`에 결과를 모아 출력

### StringBuffer → StringBuilder

```java
StringBuffer bf = new StringBuffer(); // 동기화 오버헤드 있음
```

단일 스레드 환경에서는 `StringBuilder`가 더 빠르다.

```java
StringBuilder bf = new StringBuilder();
```

### Stack → ArrayDeque

```java
Stack<Integer> stack = new Stack<>(); // Stack은 Vector를 상속, 동기화 오버헤드 있음
```

Java에서 스택 용도로는 `ArrayDeque`를 권장한다.

```java
Deque<Integer> stack = new ArrayDeque<>();
```

### 변수명

`su`, `bf`, `n` 등 축약된 이름보다 의미 있는 이름이 좋다.

```java
int target = A[i];
StringBuilder operations = new StringBuilder();
int top = stack.pop();
```

### 중괄호 생략

```java
if(result)
    System.out.println(bf.toString()); // 중괄호 없음
```

중괄호를 추가하는 것이 안전하다.
