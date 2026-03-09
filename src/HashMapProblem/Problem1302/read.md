# 백준 1302 - 베스트셀러

## 문제 요약

- 오늘 팔린 책의 목록이 주어진다.
- 가장 많이 팔린 책 이름을 출력한다.
- 판매량이 같으면 **사전 순으로 앞선 것**을 출력한다.

---

## 핵심 자료구조: HashMap

`HashMap<String, Integer>` 로 **책 이름 → 판매 횟수** 를 저장한다.

```java
hashMap.put(s, hashMap.getOrDefault(s, 0) + 1);
```

- 처음 등장하는 책이면 0에서 +1
- 이미 있는 책이면 기존 값에 +1

---

## 주의: nextInt() 후 nextLine() 버퍼 버그

`nextInt()`는 숫자만 읽고 **줄바꿈 문자(`\n`)를 버퍼에 남긴다.**
바로 `nextLine()`을 호출하면 남아있던 `\n`을 읽어 빈 문자열을 반환한다.

```
입력: "3\nbook1\nbook2\nbook3"

nextInt()  → 3 읽음, 버퍼: "\nbook1\nbook2\nbook3"
nextLine() → "\n" 읽음 → s = ""   ← 첫 번째 책을 못 읽음!
nextLine() → "book1"
nextLine() → "book2"
// book3는 아예 못 읽음
```

**해결: `nextInt()` 직후 `sc.nextLine()` 한 번 호출해서 버퍼 비우기**

```java
int x = sc.nextInt();
sc.nextLine(); // 버퍼 비우기
```

---

## 전체 흐름 예시

입력:
```
5
top
top
star
top
star
```

```
hashMap: { "top"=3, "star"=2 }
max = 3
result = ["top"]
출력: top
```

---

## 코드 리뷰

```java
int x = sc.nextInt();
sc.nextLine(); // 버퍼 비우기
HashMap<String, Integer> hashMap = new HashMap<>();
for (int i = 0; i < x; i++) {
    String s = sc.nextLine();
    hashMap.put(s, hashMap.getOrDefault(s, 0) + 1);
}

int max = Collections.max(hashMap.values());

List<String> result = new ArrayList<>();
for (String key : hashMap.keySet()) {
    if (hashMap.get(key) == max) result.add(key);
}

Collections.sort(result); // 사전순 정렬
System.out.println(result.get(0));
```

---

## 핵심 메서드 정리

| 메서드 | 설명 |
|--------|------|
| `getOrDefault(key, 0)` | key가 없으면 기본값 0 반환 |
| `Collections.max(values)` | 컬렉션에서 최댓값 반환 |
| `Collections.sort(list)` | 리스트를 사전순 정렬 |
