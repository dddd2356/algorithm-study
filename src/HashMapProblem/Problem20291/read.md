# 백준 20291 - 파일 정리 (실버 4)

## 문제 요약

- N개의 파일 이름이 주어진다.
- 확장자별 파일 개수를 사전순으로 출력한다.

---

## 핵심 아이디어

`StringTokenizer`에 구분자로 `"."` 을 주면 파일명과 확장자를 쉽게 분리할 수 있다.

```java
StringTokenizer st = new StringTokenizer(br.readLine(), ".");
String name = st.nextToken(); // 파일명 (버림)
String type = st.nextToken(); // 확장자 (key로 사용)
```

`HashMap<String, Integer>` 로 **확장자 → 개수** 를 저장한다.

```java
map.put(type, map.getOrDefault(type, 0) + 1);
```

---

## 출력 방법

key를 리스트에 담아 사전순 정렬 후, 확장자와 개수를 함께 출력한다.

```java
ArrayList<String> result = new ArrayList<>();
result.addAll(map.keySet());
Collections.sort(result);

StringBuilder sb = new StringBuilder();
for (int i = 0; i < result.size(); i++) {
    sb.append(result.get(i))
      .append(" ")
      .append(map.get(result.get(i)))
      .append("\n");
}
System.out.print(sb);
```

---

## 동작 예시

```
입력:
5
hello.txt
world.cpp
foo.txt
bar.jpg
baz.cpp

map: {"txt":2, "cpp":2, "jpg":1}
정렬 후: ["cpp", "jpg", "txt"]

출력:
cpp 2
jpg 1
txt 2
```

---

## 전체 코드

```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
int N = Integer.parseInt(br.readLine());
HashMap<String, Integer> map = new HashMap<>();

for (int i = 0; i < N; i++) {
    StringTokenizer st = new StringTokenizer(br.readLine(), ".");
    String name = st.nextToken(); // 파일명 (버림)
    String type = st.nextToken(); // 확장자
    map.put(type, map.getOrDefault(type, 0) + 1);
}

ArrayList<String> result = new ArrayList<>();
result.addAll(map.keySet());
Collections.sort(result);

StringBuilder sb = new StringBuilder();
for (int i = 0; i < result.size(); i++) {
    sb.append(result.get(i)).append(" ").append(map.get(result.get(i))).append("\n");
}
System.out.print(sb);
```

---

## 핵심 정리

| 항목 | 내용 |
|------|------|
| 확장자 분리 | StringTokenizer 구분자로 `"."` 사용 |
| 저장 | 확장자 → 개수 (HashMap) |
| 정렬 | Collections.sort() 로 사전순 |
| 출력 | StringBuilder로 한 번에 출력 |
