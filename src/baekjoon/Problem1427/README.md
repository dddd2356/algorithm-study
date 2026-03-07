# Problem 1427 - 소트인사이드

[백준 1427번](https://www.acmicpc.net/problem/1427)

## 풀이 요약

수를 문자열로 읽어 각 자릿수를 정렬 후 내림차순으로 출력.

## 코드 리뷰

### 잘된 점

- `char[]`로 변환 후 `Arrays.sort`를 사용하여 간결하게 정렬
- 역순 출력으로 내림차순 처리하는 아이디어가 영리함

### 변수명

```java
String arr = sc.nextLine(); // 문자열인데 arr은 배열처럼 읽힘
char[] arr2;                // arr과 arr2로 구분이 모호함
```

```java
String input = sc.nextLine();
char[] digits = input.toCharArray();
```

### 불필요한 분리 선언

```java
char[] arr2;
arr2 = arr.toCharArray(); // 선언과 초기화를 분리
```

한 줄로 합치는 것이 더 간결하다.

```java
char[] arr2 = arr.toCharArray();
```

### 마지막 줄바꿈 없음

```java
System.out.print(arr2[i]); // 마지막에 개행 없이 출력
```

일부 채점 시스템에서 마지막 줄바꿈을 요구할 수 있다. `println`으로 출력 후 루프를 끝내거나 루프 후 `System.out.println()`을 추가하는 것이 안전하다.
