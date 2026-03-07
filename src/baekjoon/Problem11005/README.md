# Problem 11005 - 진법 변환 2

[백준 11005번](https://www.acmicpc.net/problem/11005)

## 풀이 요약

10진법 수 N을 B진법으로 변환. 나머지를 역순으로 수집 후 `StringBuilder.reverse()`로 출력.

## 코드 리뷰

### 잘된 점

- `BufferedReader` + `StringTokenizer`로 빠른 입력
- `long` 타입으로 큰 수 처리
- N=0 엣지 케이스 처리
- `StringBuilder.reverse()`로 간결하게 역순 처리

### Integer.toString 활용

Java 내장 메서드로 더 간단하게 구현 가능하다.

```java
System.out.println(Long.toString(N, B).toUpperCase());
```

단, 이 방법은 소문자로 출력하므로 `.toUpperCase()` 필요. 또한 N=0도 자동 처리된다.

### 변수 재사용

```java
long N = Long.parseLong(st.nextToken()); // 입력값이자 루프 변수로 사용
```

입력 변수를 루프 내에서 직접 변경(`N /= B`)하고 있다. 의미상 다른 역할이므로 별도 변수로 분리하면 더 명확하다.

```java
long num = Long.parseLong(st.nextToken());
// ...
while (num > 0) { ... num /= B; }
```
