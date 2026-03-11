# Problem 5568 - 카드 놓기

[백준 5568번](https://www.acmicpc.net/problem/5568)

## 풀이 요약

n장의 카드에서 k장을 순서 있게 골라 이어 붙인 수를 만들 때, 서로 다른 수의 개수를 출력.
순열(Permutation) + HashSet으로 중복 제거.

## 코드 리뷰

### 2중 for 루프로는 k개 순열 처리 불가

```java
for(int i=0; i<num.length; i++){
    for(int j=i+1; j<k; j++){  // j<k 도 잘못된 범위
        hashMap.put(num[i]+num[j], );  // 컴파일 에러
    }
}
```

k=2일 때만 동작하고, k=3 이상은 처리할 수 없다. 또한 `j<k`는 `j<n`이어야 한다.
재귀를 사용해 k개짜리 순열을 생성해야 한다.

```java
static void permutation(String current, int depth) {
    if (depth == k) {
        set.add(current);
        return;
    }
    for (int i = 0; i < n; i++) {
        if (!visited[i]) {
            visited[i] = true;
            permutation(current + num[i], depth + 1);
            visited[i] = false;  // 백트래킹
        }
    }
}
```

### HashMap 대신 HashSet

중복된 수를 제거하는 것이 목적이므로 `HashMap` 대신 `HashSet`을 사용하면 충분하다.

```java
// 변경 전
HashMap<String, Integer> hashMap = new HashMap<>();

// 변경 후
HashSet<String> set = new HashSet<>();
```

결과는 `set.size()`로 바로 출력할 수 있다.
