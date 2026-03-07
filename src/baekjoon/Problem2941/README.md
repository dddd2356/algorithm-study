# Problem 2941 - 크로아티아 알파벳

[백준 2941번](https://www.acmicpc.net/problem/2941)

## 풀이 요약

크로아티아 특수 알파벳(2~3글자 조합)을 한 글자로 취급하여 전체 알파벳 수를 세는 문제.

## 코드 리뷰

### 잘된 점

- while + index 직접 조작으로 다중 글자 처리를 명확하게 구현함
- `private static` 메서드로 로직 분리
- 인덱스 범위 체크(`i + 1 < s.length()`)를 선행하여 안전하게 처리

### 개선 포인트

**특수 알파벳을 데이터로 분리**

현재는 각 패턴을 if-else로 하드코딩했다. 패턴 목록을 배열로 관리하면 수정이 쉽다.

```java
private static final String[] SPECIAL = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

private static int findAlphabet(String s) {
    int count = 0;
    int i = 0;
    while (i < s.length()) {
        boolean matched = false;
        for (String sp : SPECIAL) {
            if (s.startsWith(sp, i)) {
                i += sp.length();
                matched = true;
                break;
            }
        }
        if (!matched) i++;
        count++;
    }
    return count;
}
```

패턴이 추가/변경되어도 `SPECIAL` 배열만 수정하면 된다.

### 입출력

이 문제는 입력이 단순하므로 `Scanner`로 충분하다.
