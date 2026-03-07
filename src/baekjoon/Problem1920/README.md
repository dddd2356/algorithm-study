# Problem 1920 - 수 찾기

[백준 1920번](https://www.acmicpc.net/problem/1920)

## 풀이 요약

N개의 정수 집합에서 M개의 쿼리 수가 존재하는지 이진 탐색으로 확인.

## 코드 리뷰

### 잘된 점

- `BufferedReader` + `StringTokenizer`로 빠른 입출력
- `Arrays.sort` + `Arrays.binarySearch` 조합으로 간결하게 구현
- 결과를 `StringBuilder`에 모아 한 번에 출력

### 개선 포인트

**`sb.toString()` 불필요**

```java
System.out.print(sb.toString()); // toString() 호출 불필요
System.out.print(sb);            // PrintStream이 CharSequence 직접 처리
```

**`Arrays.binarySearch` 주의사항**

`Arrays.binarySearch`는 값이 없을 때 음수를 반환하는데, 값이 중복될 경우 어떤 인덱스를 반환할지 보장하지 않는다. 이 문제는 존재 여부만 확인하므로 문제없지만, 특정 위치가 필요한 경우 직접 이진 탐색 구현이 안전하다.

**HashSet 대안**

수가 중복 없이 들어온다면 `HashSet<Integer>`를 사용하면 O(1) 조회가 가능하다.

```java
Set<Integer> set = new HashSet<>();
// ... 삽입 후
sb.append(set.contains(q) ? "1\n" : "0\n");
```
