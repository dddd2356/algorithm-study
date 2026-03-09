# 백준 7785 - 회사에 있는 사람

## 문제 요약

- 직원들의 enter/leave 기록이 주어진다.
- 현재 회사에 있는 사람을 사전 역순으로 출력한다.

---

## 핵심 자료구조: HashMap

`HashMap<String, Integer>` 로 **이름 → 상태(1: 재실, 0: 퇴근)** 를 저장한다.

```java
if (status.equals("enter")) map.put(name, 1);
else                         map.put(name, 0);
```

### key 중복 불가 → 자동 덮어쓰기

HashMap은 **key 기준으로 중복 불가**이므로 같은 key로 put하면 value가 덮어써진다.
enter → leave → enter를 반복해도 마지막 상태만 남으므로 별도 처리가 필요 없다.

```
"kim" enter → {"kim": 1}
"kim" leave → {"kim": 0}  // 덮어씀
"kim" enter → {"kim": 1}  // 덮어씀 → 최종: 재실
```

- **key 중복 불가** → 같은 key로 put하면 value 덮어씀
- **value는 중복 가능** → 여러 key가 같은 value를 가질 수 있음

---

## 출력: value == 1인 key만 추출

```java
// map.get(i) → HashMap은 인덱스로 접근 불가 → null
// keySet()으로 순회해야 함

List<String> result = new ArrayList<>();
for (String key : map.keySet()) {
    if (map.get(key) == 1) result.add(key);
}
```

---

## 사전 역순 정렬

```java
Collections.sort(result, Collections.reverseOrder());
```

---

## 전체 코드

```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
int n = Integer.parseInt(br.readLine().trim());

HashMap<String, Integer> map = new HashMap<>();
for (int i = 0; i < n; i++) {
    StringTokenizer st = new StringTokenizer(br.readLine());
    String name = st.nextToken();
    String status = st.nextToken();
    if (status.equals("enter")) map.put(name, 1);
    else                        map.put(name, 0);
}

List<String> result = new ArrayList<>();
for (String key : map.keySet()) {
    if (map.get(key) == 1) result.add(key);
}

Collections.sort(result, Collections.reverseOrder());

StringBuilder sb = new StringBuilder();
for (String s : result) {
    sb.append(s).append("\n");
}
System.out.print(sb);
```

---

## 핵심 정리

| 항목 | 내용 |
|------|------|
| 저장 | enter=1, leave=0 으로 상태 저장 |
| 중복 처리 | 같은 key는 자동 덮어씀 |
| 추출 | value == 1인 key만 리스트에 추가 |
| 정렬 | Collections.reverseOrder() 로 역순 |
