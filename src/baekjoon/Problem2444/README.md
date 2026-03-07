# Problem 2444 - 별 찍기 - 7

[백준 2444번](https://www.acmicpc.net/problem/2444)

## 풀이 요약

N을 입력받아 마름모 모양의 별을 출력. 위쪽(1~N행)과 아래쪽(N-1~1행)을 분리하여 처리.

## 코드 리뷰

### 잘된 점

- 윗부분/아랫부분을 명확하게 분리하여 구조가 읽기 쉬움
- `spaces = n - i`, `stars = 2 * i - 1` 수식이 직관적

### 반복 출력에 StringBuilder 권장

```java
for (int s = 0; s < spaces; s++) System.out.print(" "); // 공백마다 출력
for (int t = 0; t < stars; t++) System.out.print("*"); // 별마다 출력
System.out.println();
```

문자를 한 글자씩 출력하면 I/O 호출이 많아진다. `StringBuilder`나 `String.repeat()`으로 한 줄을 만든 뒤 한 번에 출력하면 더 빠르다.

```java
StringBuilder sb = new StringBuilder();
// 윗부분
for (int i = 1; i <= n; i++) {
    sb.append(" ".repeat(n - i));
    sb.append("*".repeat(2 * i - 1));
    sb.append('\n');
}
// 아랫부분
for (int i = n - 1; i >= 1; i--) {
    sb.append(" ".repeat(n - i));
    sb.append("*".repeat(2 * i - 1));
    sb.append('\n');
}
System.out.print(sb);
```

### sc.close() 위치

```java
int n = sc.nextInt();
sc.close(); // 입력 직후 닫음
```

이 문제는 입력이 하나뿐이라 문제없지만, 입력이 여러 번 필요한 경우 `close()` 후 추가 읽기가 불가능하다. 일반적으로 `Scanner`는 닫지 않거나, 모든 입력을 마친 뒤 닫는 습관을 들이는 것이 좋다.

### 입출력 속도

`Scanner` 대신 `BufferedReader`를 사용하면 더 빠르다. 출력도 `StringBuilder`로 묶어 한 번에 `System.out.print(sb)` 처리 권장.
