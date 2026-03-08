# Problem 11286 - 절댓값 힙

[백준 11286번](https://www.acmicpc.net/problem/11286)

## 풀이 요약

절댓값이 가장 작은 수를 우선으로, 같으면 음수를 우선으로 꺼내는 우선순위 큐 구현.

## 코드 리뷰

### 잘된 점

- 커스텀 Comparator로 우선순위 조건을 정확하게 구현
- `BufferedReader`로 빠른 입력 처리

### 변수명 컨벤션

```java
PriorityQueue<Integer> MyQueue = ...; // 대문자 시작은 클래스명 컨벤션
```

Java에서 변수는 camelCase로 시작한다.

```java
PriorityQueue<Integer> myQueue = ...;
```

### 반복 출력에 StringBuilder 권장

```java
System.out.println("0");       // 연산마다 출력
System.out.println(MyQueue.poll());
```

연산이 최대 100,000번이므로 `StringBuilder`에 모아 한 번에 출력하면 더 빠르다.

### 중괄호 생략

```java
else
    System.out.println(MyQueue.poll()); // 중괄호 없음
```

항상 중괄호를 사용하는 것이 안전하다.

### Comparator 반환값은 저장되지 않는다

```java
// a = -3, b = 5 일 때
return Math.abs(a) - Math.abs(b); // 3 - 5 = -2
```

여기서 `-2`는 힙에 저장되는 값이 **아니다.**
반환값은 단순히 **"a와 b 중 누가 앞에 올지"를 판단하는 신호**로만 사용되고 즉시 버려진다.

| 반환값 | 의미 |
|--------|------|
| 음수 | a를 b보다 앞에 (a 우선) |
| 0 | 순서 동일 |
| 양수 | b를 a보다 앞에 (b 우선) |

힙에는 실제 값 `-3`, `5` 그대로 저장된다.

> 비유: 키를 비교해서 줄 세울 때, "A가 B보다 작다"는 판단 결과가 줄에 서는 게 아니라 A와 B 본인이 서는 것과 같다.

### Comparator 정수 오버플로우 주의

```java
return first_abs - second_abs; // 두 값의 차이가 Integer.MIN_VALUE 근처면 오버플로우 가능
```

안전하게 `Integer.compare()`를 사용하는 것이 좋다.

```java
return Integer.compare(first_abs, second_abs);
```
