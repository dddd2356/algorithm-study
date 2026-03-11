# Problem 10546 - 배부른 마라토너

[백준 10546번](https://www.acmicpc.net/problem/10546)

## 풀이 요약

N명이 출발했지만 N-1명만 완주. 완주하지 못한 선수 1명을 출력.
setB를 HashMap으로 카운트 후 setA를 순회하며 count가 0인 이름을 찾는다.

## 코드 리뷰

### 버그 1: count 초기화 누락

```java
int count = 0;  // 루프 밖에 선언

for(int i=0; i<n; i++) {
    for(int j=0; j<n-1; j++){
        if(...) { count++; break; }
    }
    if(count == 0) { ... }  // count가 한번 1이 되면 영원히 1
}
```

`count`가 바깥 루프 안에서 초기화되지 않아 한번 1이 되면 다시 0으로 돌아오지 않는다.
매 `i` 반복마다 `count = 0`으로 초기화해야 한다.

### 버그 2: contains() vs equals()

```java
if(setA[i].contains(setB[j]))  // 부분 문자열 포함 여부
```

`"mislav".contains("lav")` → `true` 가 되어버린다.
이름이 정확히 같은지 비교하려면 `equals()`를 사용해야 한다.

### 버그 3: 동명이인 처리 불가

같은 이름이 여러 명일 수 있다. `HashSet`은 중복을 허용하지 않으므로 동명이인을 처리할 수 없다.
`HashMap`으로 빈도수를 관리해야 한다.

### 올바른 풀이: HashMap 활용

```java
// setB를 HashMap에 카운트
for (int i = 0; i < n - 1; i++) {
    String name = br.readLine();
    map.put(name, map.getOrDefault(name, 0) + 1);
}

// setA를 순회하며 count가 0인 이름이 정답
for (int i = 0; i < n; i++) {
    if (map.getOrDefault(setA[i], 0) == 0) {
        System.out.println(setA[i]);
        break;
    }
    map.put(setA[i], map.get(setA[i]) - 1);  // 완주 처리 (동명이인 소비)
}
```

**단계별 예시**

```
setA = ["ana", "mislav", "mislav"]
setB = ["ana", "mislav"]

초기 map = { "ana":1, "mislav":1 }

i=0, "ana"    → count 1 → 차감 → { "ana":0, "mislav":1 }
i=1, "mislav" → count 1 → 차감 → { "ana":0, "mislav":0 }
i=2, "mislav" → count 0 → 정답! → "mislav" 출력
```
