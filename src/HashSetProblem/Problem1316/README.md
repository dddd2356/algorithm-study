# Problem 1316 - 그룹 단어 체커

[백준 1316번](https://www.acmicpc.net/problem/1316)

## 풀이 요약

단어에서 각 문자가 연속된 구간에만 나타나면 그룹 단어.
새 그룹이 시작될 때 HashSet으로 이미 등장한 문자인지 체크한다.

## 핵심 알고리즘

### 그룹 단어 조건
- `aabbb` → a그룹, b그룹 → 그룹 단어 ✓
- `aabbbccb` → a그룹, b그룹, c그룹, b재등장 → 그룹 단어 아님 ✗

### 동작 원리

새 그룹이 시작될 때(`이전 문자 != 현재 문자`)만 HashSet에 추가를 시도한다.
`hashSet.add()`는 추가와 중복 체크를 동시에 수행한다.
- 추가 성공(`true`) → 처음 나온 문자 → 정상
- 추가 실패(`false`) → 이미 나온 문자 재등장 → 그룹 단어 아님

```
"aabbbccb" 예시

초기: hashSet = {a}  ← charAt(0)

j=2: a!=b → hashSet.add('b') 성공(true)  → hashSet={a,b} → 정상
j=5: b!=c → hashSet.add('c') 성공(true)  → hashSet={a,b,c} → 정상
j=6: c!=b → hashSet.add('b') 실패(false) → 이미 있음 → isTrue=false ❌
```

### 구현

```java
hashSet.add(a.charAt(0)); // 첫 문자 추가
for (int j = 1; j < a.length(); j++) {
    if (a.charAt(j-1) != a.charAt(j)) { // 새 그룹 시작
        if (!hashSet.add(a.charAt(j))) { // 이미 나온 문자면 실패
            isTrue = false;
            break;
        }
    }
}
```

## 주의사항

- `hashSet`은 단어마다 새로 생성해야 함 (단어 간 공유 X)
- `isTrue` 초기값은 `true` (길이 1짜리 단어도 그룹 단어)
- 첫 문자는 루프 밖에서 미리 추가, 루프 안에서 중복 추가하면 체크 불가
