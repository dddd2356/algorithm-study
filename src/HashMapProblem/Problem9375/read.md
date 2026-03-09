# 백준 9375 - 패션왕 신해빈

## 문제 요약

- 의상의 이름과 종류가 주어진다.
- 종류별로 최대 1개씩 입을 수 있고, 입지 않아도 된다.
- 단, 아무것도 안 입는 경우는 제외한다.
- 가능한 의상 조합의 수를 출력한다.

---

## 핵심 자료구조: HashMap

`HashMap<String, Integer>` 로 **의상 종류 → 개수** 를 저장한다.
의상 이름은 필요 없고 종류별 개수만 필요하다.

```java
String name = st.nextToken(); // 의상 이름 (버림)
String type = st.nextToken(); // 의상 종류 (key로 사용)
map.put(type, map.getOrDefault(type, 0) + 1);
```

---

## 조합 계산 공식

각 종류마다 "안 입는 경우"를 포함해서 **(개수 + 1)** 을 곱하고,
마지막에 "아무것도 안 입는 경우(나체)" 1을 뺀다.

```
(종류1 개수 + 1) * (종류2 개수 + 1) * ... - 1
```

### 예시: 얼굴(2개), 상의(1개), 하의(3개)

```
얼굴:  안입기 + A + B         → 3가지 (2+1)
상의:  안입기 + C             → 2가지 (1+1)
하의:  안입기 + D + E + F     → 4가지 (3+1)

3 * 2 * 4 = 24
24 - 1 = 23  (나체 제외)
```

```java
int result = 1;
for (int count : map.values()) {
    result *= (count + 1);  // 각 종류마다 (개수 + 1) 곱하기
}
result -= 1;  // 아무것도 안 입는 경우 제외
```

---

## 주의: nextInt() 후 nextLine() 버퍼 비우기

`nextInt()` 는 숫자만 읽고 `\n` 을 버퍼에 남긴다.
테스트케이스마다 `n = sc.nextInt()` 다음에도 버퍼 비우기가 필요하다.

```java
int testCase = sc.nextInt();
sc.nextLine(); // 버퍼 비우기

for (int i = 0; i < testCase; i++) {
    int n = sc.nextInt();
    sc.nextLine(); // 버퍼 비우기 (이게 없으면 첫 줄을 빈 문자열로 읽음)
    ...
}
```

---

## 전체 코드

```java
Scanner sc = new Scanner(System.in);
int testCase = sc.nextInt();
sc.nextLine();

for (int i = 0; i < testCase; i++) {
    int n = sc.nextInt();
    sc.nextLine();
    HashMap<String, Integer> map = new HashMap<>();

    for (int j = 0; j < n; j++) {
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        String name = st.nextToken(); // 의상 이름 (버림)
        String type = st.nextToken(); // 의상 종류
        map.put(type, map.getOrDefault(type, 0) + 1);
    }

    int result = 1;
    for (int count : map.values()) {
        result *= (count + 1);
    }
    result -= 1;
    System.out.println(result);
}
```

---

## 핵심 정리

| 항목 | 내용 |
|------|------|
| 저장 | 종류별 개수를 HashMap에 저장 |
| 공식 | 각 종류 (개수+1) 곱한 뒤 -1 |
| 버퍼 비우기 | nextInt() 후 nextLine() 필수 |
