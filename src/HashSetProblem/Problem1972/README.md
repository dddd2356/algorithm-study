# Problem 1972 - 놀라운 문자열

[백준 1972번](https://www.acmicpc.net/problem/1972)

## 풀이 요약

문자열이 주어질 때, 모든 간격 D (1 ≤ D ≤ len-1)에서 거리가 D인 문자 쌍이 중복 없이 유일하면 "놀라운 문자열"이다.
HashSet으로 각 간격마다 쌍의 중복 여부를 체크한다.

## 핵심 알고리즘

### D-유일 조건
간격 D에서 만들어지는 모든 쌍 `(s[j], s[j+D])`이 서로 달라야 한다.

```
예) "AABB", D=1
쌍: (A,A), (A,B), (B,B) → 중복 없음 ✓

예) "AABB", D=2
쌍: (A,B), (A,B) → 중복 발생 → NOT surprising
```

### 구현

```java
static boolean isSurprising(String s) {
    // 간격 i = 1부터 len-1까지 검사
    for (int i = 1; i < s.length(); i++) {
        HashSet<String> set = new HashSet<>();
        // 간격 i인 두 문자를 쌍으로 만들어 중복 체크
        for (int j = 0; j + i < s.length(); j++) {
            String pair = "" + s.charAt(j) + s.charAt(j + i);
            if (!set.add(pair)) return false; // 중복 쌍 → NOT surprising
        }
    }
    return true; // 모든 간격에서 중복 없음 → surprising
}
```

## 입출력

- 입력: 알파벳 대문자 문자열 (길이 ≤ 80), 마지막 줄은 `*`
- 출력: `X is surprising.` 또는 `X is NOT surprising.`

## 예제

| 입력 | 출력 |
|------|------|
| ZGBG | ZGBG is surprising. |
| AABB | AABB is NOT surprising. |
| BCBABCC | BCBABCC is NOT surprising. |
