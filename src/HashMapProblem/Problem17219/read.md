# 백준 17219 - 비밀번호 찾기

## 문제 요약

- N개의 사이트 주소와 비밀번호가 주어진다.
- M개의 사이트 주소가 주어지면 해당 비밀번호를 출력한다.

---

## 핵심 자료구조: HashMap

`HashMap<String, String>` 으로 **사이트 주소 → 비밀번호** 를 저장한다.

```
key         value
"naver"     "1234"
"google"    "abcd"
"kakao"     "pw123"
```

---

## 핵심 동작: map.get(key)

`map.get(key)` 는 **key에 해당하는 value를 반환**한다.

입력받은 사이트 이름 `s` 자체가 key이므로 `map.get(s)` 로 바로 비밀번호를 꺼낼 수 있다.

```java
String s = br.readLine();          // 사이트 이름 = key
if (map.containsKey(s)) {
    result.add(map.get(s));        // 비밀번호 = value
}
```

### 흔한 실수
```java
String key = map.values().toString(); // values()는 value 목록 → key가 아님
result.add(map.get(key));             // 엉뚱한 값으로 get → null 반환
```

---

## 전체 코드

```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
StringTokenizer st = new StringTokenizer(br.readLine());
int N = Integer.parseInt(st.nextToken());
int M = Integer.parseInt(st.nextToken());

HashMap<String, String> map = new HashMap<>();
for (int i = 0; i < N; i++) {
    StringTokenizer str = new StringTokenizer(br.readLine());
    map.put(str.nextToken(), str.nextToken()); // 주소, 비밀번호
}

ArrayList<String> result = new ArrayList<>();
for (int i = 0; i < M; i++) {
    String s = br.readLine();
    if (map.containsKey(s)) {
        result.add(map.get(s));
    }
}

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
| 저장 | `map.put(주소, 비밀번호)` |
| 조회 | `map.get(주소)` → 비밀번호 반환 |
| 존재 확인 | `map.containsKey(s)` |
| 입출력 최적화 | BufferedReader + StringBuilder |
