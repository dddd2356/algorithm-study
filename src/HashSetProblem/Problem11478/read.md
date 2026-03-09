# 백준 11478 - 서로 다른 부분 문자열의 개수

## 문제 요약

- 문자열 S가 주어진다.
- S의 서로 다른 부분 문자열의 개수를 출력한다.

---

## 핵심 자료구조: HashSet

`HashSet`은 **중복을 자동으로 무시**한다.
같은 값을 `add()`해도 한 번만 저장되므로, 모든 부분 문자열을 넣고 `size()`만 출력하면 끝.

```java
// ArrayList는 중복 저장됨
list.add("a") → ["a"]
list.add("a") → ["a", "a"]  // 중복!

// HashSet은 중복 무시
set.add("a") → {"a"}
set.add("a") → {"a"}        // 그대로
```

---

## 부분 문자열 추출 방법

시작 인덱스 `i`와 끝 인덱스 `j`로 모든 부분 문자열을 만든다.

```java
for (int i = 0; i < s.length(); i++) {
    for (int j = i + 1; j <= s.length(); j++) {
        set.add(s.substring(i, j));
    }
}
```

`substring(i, j)` → 인덱스 `i` 이상 `j` 미만의 문자열 반환

---

## 동작 예시

**s = "ababc"**

```
i=0 → "a", "ab", "aba", "abab", "ababc"
i=1 → "b", "ba", "bab", "babc"
i=2 → "a"(무시), "ab"(무시), "abc"
i=3 → "b"(무시), "bc"
i=4 → "c"
```

**HashSet 최종 상태:**
```
{"a", "ab", "aba", "abab", "ababc", "b", "ba", "bab", "babc", "abc", "bc", "c"}
```

→ `set.size()` = **12** 출력

---

## 전체 코드

```java
Scanner sc = new Scanner(System.in);
String s = sc.next();
HashSet<String> set = new HashSet<>();

for (int i = 0; i < s.length(); i++) {
    for (int j = i + 1; j <= s.length(); j++) {
        set.add(s.substring(i, j));
    }
}

System.out.println(set.size());
```

---

## 핵심 메서드 정리

| 메서드 | 설명 |
|--------|------|
| `substring(i, j)` | 인덱스 i 이상 j 미만의 문자열 반환 |
| `set.add(s)` | 중복이면 무시, 아니면 추가 |
| `set.size()` | 저장된 고유 원소 개수 반환 |
