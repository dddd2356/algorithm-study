# Problem 2420 - 사문어

[백준 2420번](https://www.acmicpc.net/problem/2420)

## 풀이 요약

N개의 문자열 중 "AA" 또는 "BB"가 존재하면 1, 없으면 0 출력.

## 코드 리뷰

### 잘된 점

- 조건 일치 시 즉시 `break`하여 불필요한 탐색 중단
- `equals`로 문자열 비교 (== 대신 올바른 방법)

### 변수명

```java
String arr = sc.nextLine(); // 문자열인데 arr이라는 이름은 오해를 유발
```

```java
String line = sc.nextLine(); // 더 명확한 이름
```

### 출력 간소화

0 또는 1만 출력하므로 boolean 변수로 관리하면 더 명확하다.

```java
boolean found = false;
for (int i = 0; i < N; i++) {
    String line = sc.nextLine();
    if (line.equals("AA") || line.equals("BB")) {
        found = true;
        break;
    }
}
System.out.println(found ? 1 : 0);
```
