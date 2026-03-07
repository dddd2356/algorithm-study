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

### Comparator 정수 오버플로우 주의

```java
return first_abs - second_abs; // 두 값의 차이가 Integer.MIN_VALUE 근처면 오버플로우 가능
```

안전하게 `Integer.compare()`를 사용하는 것이 좋다.

```java
return Integer.compare(first_abs, second_abs);
```
