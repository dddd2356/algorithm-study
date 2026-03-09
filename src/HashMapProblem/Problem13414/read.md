# 백준 13414 - 수강신청

## 문제 요약

- K: 수강 정원, L: 대기 목록 길이
- 같은 학번이 여러 번 나오면 **마지막 신청 순서**로 대기열 갱신
- 최종 대기열에서 K명까지 출력

---

## 핵심 아이디어

`HashMap<String, Integer>` 로 **학번 → 마지막 신청 순서(인덱스)** 를 저장한다.
같은 학번이 다시 오면 `put`으로 순서를 덮어쓴다.

```java
map.put(student, i); // 마지막 등장 순서로 갱신
```

### 동작 예시

```
입력 순서: A B A C
i=0: map {"A": 0}
i=1: map {"A": 0, "B": 1}
i=2: map {"A": 2, "B": 1}   // A의 순서가 0→2로 갱신
i=3: map {"A": 2, "B": 1, "C": 3}

정렬 후 대기열: B(1), A(2), C(3)
```

---

## 리스트에 key만 담아도 value로 비교 가능

`result`에는 key(학번)만 담겨있지만, 정렬 시 `map.get(a)`로 value를 꺼낼 수 있어 비교가 가능하다.

```java
result.addAll(map.keySet()); // 중복 제거된 학번을 리스트에 추가

Collections.sort(result, (a, b) -> map.get(a) - map.get(b));
//                         ↑ key    ↑ key의 value(순서)로 비교
```

---

## 전체 코드

```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
StringTokenizer st = new StringTokenizer(br.readLine());
int K = Integer.parseInt(st.nextToken());
int L = Integer.parseInt(st.nextToken());

HashMap<String, Integer> map = new HashMap<>();
for (int i = 0; i < L; i++) {
    String student = br.readLine();
    map.put(student, i); // 마지막 신청 순서로 덮어씀
}

ArrayList<String> result = new ArrayList<>();
result.addAll(map.keySet());

Collections.sort(result, (a, b) -> map.get(a) - map.get(b));

StringBuilder sb = new StringBuilder();
for (int i = 0; i < K; i++) {
    sb.append(result.get(i)).append("\n");
}
System.out.print(sb);
```

---

## 코드 리뷰 (기존 코드 문제점)

```java
// 1. result에 아무것도 안 넣고 정렬
Collections.sort(result, (a, b) -> { ... }); // result가 비어있음

// 2. 빈도를 저장 (잘못된 접근)
map.put(student, map.getOrDefault(student, 0) + 1);
// → 순서가 아닌 등장 횟수를 저장하면 대기열 순서를 알 수 없음

// 3. 출력 시 result가 비어있어 IndexOutOfBoundsException 발생
for (int i = 0; i < K; i++) {
    System.out.println(result.get(i)); // result가 비어있어 오류
}
```

### 수정 포인트

| 문제 | 원인 | 해결 |
|------|------|------|
| result가 비어있음 | keySet을 담지 않음 | `result.addAll(map.keySet())` |
| 정렬 기준 오류 | 빈도로 저장 | 마지막 순서(i)로 저장 |
| 시간 초과 가능 | Scanner 사용 | BufferedReader로 교체 |

---

## 핵심 정리

| 항목 | 내용 |
|------|------|
| 저장 | 학번 → 마지막 신청 순서(i) |
| 중복 처리 | 같은 key는 자동 덮어씀 |
| 정렬 | value(순서) 기준 오름차순 |
| 출력 | K명까지만 출력 |
