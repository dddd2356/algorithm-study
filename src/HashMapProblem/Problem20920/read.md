# 백준 20920 - 영단어 암기는 괴로워

## 문제 요약

- N개의 단어가 주어진다.
- 길이가 M 이상인 단어만 외운다.
- 아래 기준으로 정렬해서 출력한다.
  1. 자주 나온 단어일수록 앞
  2. 길이가 길수록 앞
  3. 위 둘이 같으면 사전순

---

## 핵심 자료구조: HashMap + List

`HashMap<String, Integer>` 로 단어 → 빈도를 저장하고,
길이 M 이상인 단어만 List에 담아 정렬한다.

```java
for (String key : map.keySet()) {
    if (key.length() >= M) result.add(key); // 빈도가 아닌 길이로 필터링
}
```

---

## 정렬 기준: Comparator

단순 사전순이 아니라 3단계 기준으로 정렬해야 한다.

```java
Collections.sort(result, (a, b) -> {
    if (map.get(b) != map.get(a)) return map.get(b) - map.get(a); // 빈도 내림차순
    if (b.length() != a.length()) return b.length() - a.length(); // 길이 내림차순
    return a.compareTo(b);                                         // 사전순
});
```

### Comparator 반환값 의미
```
음수 → a가 b보다 앞
0    → 순서 유지
양수 → b가 a보다 앞
```

### 동작 예시

| 단어 | 빈도 | 길이 |
|------|------|------|
| "i" | 2 | 1 |
| "am" | 2 | 2 |
| "the" | 3 | 3 |
| "apple" | 3 | 5 |

```
1단계 (빈도): apple=3, the=3 → am=2, i=2
2단계 (길이): apple(5) > the(3) → am(2) > i(1)
최종: "apple", "the", "am", "i"
```

---

## 시간 초과 해결: BufferedReader + StringBuilder

`Scanner`는 느려서 N이 클 때 시간 초과가 난다.
`BufferedReader`로 입력, `StringBuilder`로 출력을 한 번에 처리한다.

```java
// 입력
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
StringTokenizer st = new StringTokenizer(br.readLine());
int N = Integer.parseInt(st.nextToken());
int M = Integer.parseInt(st.nextToken());

for (int i = 0; i < N; i++) {
    String s = br.readLine();
    map.put(s, map.getOrDefault(s, 0) + 1);
}

// 출력
StringBuilder sb = new StringBuilder();
for (int i = 0; i < result.size(); i++) {
    sb.append(result.get(i)).append("\n");
}
System.out.print(sb);
```

---

## 전체 코드

```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
StringTokenizer st = new StringTokenizer(br.readLine());
int N = Integer.parseInt(st.nextToken());
int M = Integer.parseInt(st.nextToken());

HashMap<String, Integer> map = new HashMap<>();
for (int i = 0; i < N; i++) {
    String s = br.readLine();
    map.put(s, map.getOrDefault(s, 0) + 1);
}

List<String> result = new ArrayList<>();
for (String key : map.keySet()) {
    if (key.length() >= M) result.add(key);
}

Collections.sort(result, (a, b) -> {
    if (map.get(b) != map.get(a)) return map.get(b) - map.get(a);
    if (b.length() != a.length()) return b.length() - a.length();
    return a.compareTo(b);
});

StringBuilder sb = new StringBuilder();
for (int i = 0; i < result.size(); i++) {
    sb.append(result.get(i)).append("\n");
}
System.out.print(sb);
```

---

## 핵심 정리

| 항목 | 내용 |
|------|------|
| 필터링 기준 | 빈도가 아닌 **단어 길이** >= M |
| 정렬 | 빈도 내림차순 → 길이 내림차순 → 사전순 |
| 입력 최적화 | Scanner 대신 BufferedReader 사용 |
| 출력 최적화 | println 반복 대신 StringBuilder로 한 번에 출력 |
