# Problem 12891 - DNA 비밀번호

[백준 12891번](https://www.acmicpc.net/problem/12891)

## 풀이 요약

슬라이딩 윈도우로 길이 P인 부분 문자열이 ACGT 최소 개수 조건을 만족하는 경우를 카운트.
`checkSecret`이 4이면 조건을 모두 충족.

## 코드 리뷰

### 잘된 점

- 슬라이딩 윈도우를 올바르게 구현
- `checkSecret` 카운터로 4가지 조건을 한 번에 검사하는 아이디어가 효율적

### C스타일 배열 선언

```java
static int myArr[];   // C 스타일
static int checkArr[];
```

Java 컨벤션은 타입 옆에 `[]`를 붙인다.

```java
static int[] myArr;
static int[] checkArr;
```

### 불필요한 배열 할당

```java
char[] A = new char[S]; // 할당했다가
A = br.readLine().toCharArray(); // 바로 덮어씀 → 첫 줄 낭비
```

```java
char[] A = br.readLine().toCharArray(); // 한 줄로 충분
```

### static 필드 사용

`myArr`, `checkArr`, `checkSecret`을 static 필드로 선언했는데, 이 문제는 단일 테스트케이스이므로 지역 변수로 선언하는 것이 더 안전하다. static 필드는 상태가 공유되어 예상치 못한 사이드이펙트를 낼 수 있다.

### 변수명

`Result`는 Java 컨벤션상 `result`(소문자 시작)로 쓰는 것이 맞다.
