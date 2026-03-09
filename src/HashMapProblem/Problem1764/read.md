# 백준 1764 - 듣보잡

## 문제 요약

- 듣도 못한 사람 N명, 보도 못한 사람 M명이 주어진다.
- 듣도 보도 못한 사람(둘 다 등장한 사람)을 사전순으로 출력한다.

---

## 핵심 아이디어: HashMap으로 등장 횟수 카운트

N명 + M명을 모두 HashMap에 넣으면서 등장 횟수를 센다.
횟수가 2이면 두 목록 모두에 등장한 사람이다.

```java
map.put(s, map.getOrDefault(s, 0) + 1);
if (map.get(s) == 2) result.add(s);  // 두 번 등장 = 듣보잡
```

### 동작 예시

```
N=3 (듣도 못한): "kim", "lee", "park"
M=4 (보도 못한): "choi", "lee", "park", "oh"

kim  → 1회
lee  → 1회
park → 1회
choi → 1회
lee  → 2회 ← 추가
park → 2회 ← 추가
oh   → 1회

result: ["lee", "park"]
```

---

## 전체 코드

```java
Scanner sc = new Scanner(System.in);
int N = sc.nextInt();
int M = sc.nextInt();
sc.nextLine();

HashMap<String, Integer> map = new HashMap<>();
ArrayList<String> result = new ArrayList<>();

for (int i = 0; i < N + M; i++) {
    String s = sc.nextLine();
    map.put(s, map.getOrDefault(s, 0) + 1);
    if (map.get(s) == 2) result.add(s);
}

Collections.sort(result);
System.out.println(result.size());
for (int i = 0; i < result.size(); i++) {
    System.out.println(result.get(i));
}
```

---

## 핵심 정리

| 항목 | 내용 |
|------|------|
| 아이디어 | N+M 전체를 하나의 반복문으로 처리 |
| 조건 | 등장 횟수 == 2 이면 듣보잡 |
| 정렬 | Collections.sort() 로 사전순 |
| 출력 | 개수 먼저, 이름 순서대로 출력 |
