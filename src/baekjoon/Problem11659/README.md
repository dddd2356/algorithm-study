# Problem 11659 - 구간 합 구하기 4

[백준 11659번](https://www.acmicpc.net/problem/11659)

## 풀이 요약

누적 합 배열 `S`를 구성하여 구간 합 쿼리를 O(1)로 처리.
`S[j] - S[i-1]`로 i~j 구간 합을 계산.

## 코드 리뷰

### 주석 처리된 코드 정리 필요

파일의 절반이 주석 처리된 이전 풀이 코드다. 버전 관리는 git으로 하고, 파일에서 삭제하는 것이 좋다.

```java
// 삭제 권장: 주석 처리된 Scanner 풀이 전체
```

### 미사용 import

```java
import java.util.Scanner; // 삭제 필요 - 사용되지 않음
```

### 반복 출력에 StringBuilder 권장

```java
for(int q=0; q<quizNo; q++){
    // ...
    System.out.println(S[j] - S[i-1]); // 쿼리마다 출력 → 느림
}
```

쿼리 수가 최대 100,000개이므로 `StringBuilder`에 모아서 한 번에 출력하면 더 빠르다.

```java
StringBuilder sb = new StringBuilder();
// ...
sb.append(S[j] - S[i-1]).append('\n');
System.out.print(sb);
```

### 변수명

`suNo`, `quizNo` 대신 `N`, `M`처럼 문제에서 사용하는 변수명을 쓰면 가독성이 높다.
