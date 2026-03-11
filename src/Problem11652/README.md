# Problem 11652 - 카드

[백준 11652번](https://www.acmicpc.net/problem/11652)

## 풀이 요약

N장의 카드 중 가장 많이 가진 정수를 출력. 여러 개면 가장 작은 수 출력.
HashMap으로 빈도수 계산 + PriorityQueue로 정렬 후 최솟값 추출.

## 코드 리뷰

### 핵심 버그: 문자열 정렬 vs 숫자 정렬 불일치

```java
HashMap<String, Integer> hashMap = new HashMap<>();
PriorityQueue<String> pq = new PriorityQueue<>();
```

`PriorityQueue<String>`은 사전순(lexicographic)으로 정렬한다.
숫자를 문자열로 비교하면 틀린 결과가 나온다.

- `"10"` vs `"9"` → 사전순: `"10"` 먼저 (틀림), 숫자순: `9` 먼저 (맞음)
- `"-1"` vs `"-2"` → 사전순: `"-1"` 먼저 (틀림), 숫자순: `"-2"` 먼저 (맞음)

입력 범위가 `-2^62 ~ 2^62`이므로 `long`으로 파싱해서 숫자로 비교해야 한다.

```java
// 변경 전
HashMap<String, Integer> hashMap = new HashMap<>();
PriorityQueue<String> pq = new PriorityQueue<>();
String num = sc.nextLine();

// 변경 후
HashMap<Long, Integer> hashMap = new HashMap<>();
PriorityQueue<Long> pq = new PriorityQueue<>();
long num = sc.nextLong();
```

### 불필요한 ArrayList

```java
ArrayList<String> result = new ArrayList<>();
result.addAll(hashMap.keySet());
for(int i=0; i<hashMap.size(); i++){
    if(hashMap.get(result.get(i)) > max){ ... }
}
```

`hashMap.keySet()`을 직접 순회하면 `ArrayList`가 필요 없다.

```java
for (long key : hashMap.keySet()) {
    if (hashMap.get(key) > max) {
        max = hashMap.get(key);
    }
}
```

### 입출력 속도

N이 최대 100,000이므로 `Scanner` 대신 `BufferedReader`를 사용하면 더 빠르다.

```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
int N = Integer.parseInt(br.readLine());
long num = Long.parseLong(br.readLine());
```
