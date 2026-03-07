# Problem 2018 - 수들의 합 5

[백준 2018번](https://www.acmicpc.net/problem/2018)

## 풀이 요약

연속된 자연수의 합으로 N을 나타내는 경우의 수를 투 포인터로 구함.
`count = 1`로 초기화하여 N 자체(단독 수열)를 미리 포함.

## 코드 리뷰

### 잘된 점

- 투 포인터 알고리즘을 올바르게 적용
- `count = 1` 초기값으로 `[N]` 케이스를 사전에 처리한 점이 영리함
- 로직이 명확하고 간결함

### 변수명 스타일

```java
int start_index = 1;
int end_index = 1;
```

Java 컨벤션은 camelCase를 사용한다.

```java
int startIndex = 1;
int endIndex = 1;
```

### 종료 조건 엣지 케이스

```java
while(end_index != N)
```

`end_index`가 N을 초과하더라도 루프가 종료된다 (`sum > N` 분기에서 `start_index`가 올라가면서 자연스럽게 처리됨). 다만 조건을 `end_index < N`으로 쓰면 의도가 더 명확하다.
