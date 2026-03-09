# 백준 1269 - 대칭 차집합

## 문제 요약

- 집합 A, B가 주어진다.
- 대칭 차집합(A에만 있는 원소 + B에만 있는 원소)의 개수를 출력한다.

---

## 시간 초과: 이중 for문 O(A×B)

```java
for (int i = 0; i < A; i++) {
    for (int j = 0; j < B; j++) {
        if (arrayA[i] == arrayB[j]) countA--;
    }
}
```

A, B의 크기가 크면 **O(A×B)** 로 시간 초과가 발생한다.

---

## 해결: HashSet O(A+B)

`HashSet.contains()`는 **O(1)** 이라 배열 전체를 돌 필요가 없다.

```java
HashSet<Integer> setA = new HashSet<>();
HashSet<Integer> setB = new HashSet<>();

for (int i = 0; i < A; i++) setA.add(sc.nextInt());
for (int i = 0; i < B; i++) setB.add(sc.nextInt());

int countA = 0, countB = 0;

for (int num : setA) {
    if (!setB.contains(num)) countA++; // A에만 있는 것
}
for (int num : setB) {
    if (!setA.contains(num)) countB++; // B에만 있는 것
}

System.out.println(countA + countB);
```

| 방식 | 시간복잡도 |
|------|-----------|
| 이중 for문 | O(A × B) |
| HashSet | O(A + B) |

---

## 동작 예시

```
A = {1, 2, 3, 4, 5}
B = {3, 4, 5, 6, 7}

A에만 있는 것: 1, 2       → countA = 2
B에만 있는 것: 6, 7       → countB = 2

출력: 4
```

---

## 전체 코드

```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
StringTokenizer st = new StringTokenizer(br.readLine());
int A = Integer.parseInt(st.nextToken());
int B = Integer.parseInt(st.nextToken());

HashSet<Integer> setA = new HashSet<>();
HashSet<Integer> setB = new HashSet<>();

st = new StringTokenizer(br.readLine());
for (int i = 0; i < A; i++) setA.add(Integer.parseInt(st.nextToken()));

st = new StringTokenizer(br.readLine());
for (int i = 0; i < B; i++) setB.add(Integer.parseInt(st.nextToken()));

int countA = 0, countB = 0;

for (int num : setA) {
    if (!setB.contains(num)) countA++;
}
for (int num : setB) {
    if (!setA.contains(num)) countB++;
}

System.out.println(countA + countB);
```

---

## 핵심 정리

| 항목 | 내용 |
|------|------|
| 자료구조 | HashSet (중복 제거 + O(1) 탐색) |
| 핵심 메서드 | `contains()` → O(1) |
| 시간복잡도 | O(A+B) |
