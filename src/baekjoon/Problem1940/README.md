# Problem 1940 - 주몽

[백준 1940번](https://www.acmicpc.net/problem/1940)

## 풀이 요약

재료 번호 합이 M인 쌍의 개수를 투 포인터로 탐색. 정렬 후 양 끝에서 좁혀가며 합이 M인 경우 카운트.

## 코드 리뷰

### 잘된 점

- `BufferedReader` + `StringTokenizer`로 빠른 입출력
- 투 포인터를 올바르게 적용

### 주석 처리된 코드 정리 필요

파일 절반이 주석 처리된 이전 풀이다. git으로 관리하고 파일에서 삭제하는 것이 좋다.

### 미사용 import

```java
import java.util.Scanner; // 사용되지 않음 - 삭제 필요
```

### 변수명

`A` 대신 `arr`처럼 의미 있는 이름을 쓰면 가독성이 좋아진다.
