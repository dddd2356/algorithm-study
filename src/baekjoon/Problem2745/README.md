# Problem 2745 - 진법 변환

[백준 2745번](https://www.acmicpc.net/problem/2745)

## 풀이 요약

B진법 수 N을 10진법으로 변환. 각 자릿수에 B를 거듭 곱하면서 누적 합산 (Horner's method).

## 코드 리뷰

### 잘된 점

- Horner's method로 간결하게 구현
- `long` 타입으로 오버플로우 방지
- `Character.isDigit`으로 숫자/문자 구분 처리

### 예외 처리 방식

```java
if (value >= B) {
    throw new IllegalArgumentException(...); // 런타임 예외
}
```

경쟁 프로그래밍에서 입력은 항상 유효하다고 가정한다. 이 예외는 문제 조건상 절대 발생하지 않으므로 불필요하다. 오히려 실수로 트리거되면 런타임 에러가 발생할 수 있다. 삭제하는 것이 좋다.

### Long.parseLong 활용

Java 내장 메서드로 더 간단하게 구현 가능하다.

```java
System.out.println(Long.parseLong(N, B));
```

단, 이 방법은 소문자 입력도 처리하는 반면 현재 코드는 대문자만 처리하므로 문제 조건 확인 필요.
