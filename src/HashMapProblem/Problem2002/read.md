# 백준 2002 - 추월

## 문제 요약

- 터널에 진입하는 순서(A)와 나오는 순서(B)가 주어진다.
- 터널 안에서 추월한 차의 수를 출력한다.

---

## 추월 조건

**추월한 차 X** = B에서 X보다 뒤에 나왔는데 A에서는 X보다 앞에 있는 차가 존재하는 경우

```
A: 1 2 3 4 5
B: 2 1 4 5 3
A순서: 1 0 3 4 2  (B 순서로 나열)

- 차2(A순서1): 뒤에 차1(A순서0)이 있음 → 추월!
- 차1(A순서0): 뒤에 자신보다 작은 A순서 없음 → 추월 안함
- 차4(A순서3): 뒤에 차3(A순서2)이 있음 → 추월!
- 차5(A순서4): 뒤에 차3(A순서2)이 있음 → 추월!
- 차3(A순서2): 뒤에 없음 → 추월 안함

정답: 3
```

---

## 알고리즘: 이중 for문 O(N²)

B에서 i번째 차에 대해, i+1 이후에 A순서가 더 작은 차가 있으면 추월한 것.
하나라도 찾으면 `break`로 중단 (같은 차를 여러 번 카운트 방지)

```java
int result = 0;
for (int i = 0; i < N; i++) {
    int orderA_i = mapA.get(arrayB[i]);
    for (int j = i + 1; j < N; j++) {
        int orderA_j = mapA.get(arrayB[j]);
        if (orderA_j < orderA_i) {  // 뒤에 나왔는데 A순서가 앞
            result++;
            break;  // 하나라도 있으면 추월한 것, 중복 카운트 방지
        }
    }
}
```

---

## 자료구조 선택 이유

- **mapA** (`HashMap<String, Integer>`): 차번호 → A에서의 순서 (O(1) 조회)
- **arrayB** (`String[]`): B 순서를 인덱스로 접근하기 위해 배열 사용

```java
// mapA: 차번호로 A순서를 빠르게 조회
HashMap<String, Integer> mapA = new HashMap<>();
for (int i = 0; i < N; i++) {
    mapA.put(sc.nextLine(), i);
}

// arrayB: B 순서대로 인덱스 접근
String[] arrayB = new String[N];
for (int i = 0; i < N; i++) {
    arrayB[i] = sc.nextLine();
}
```

---

## 코드 리뷰 (기존 코드 문제점)

```java
// 1. mapA.get(i) → key가 String인데 int로 조회 → null
for (int i = 0; i < N; i++) {
    if (mapA.get(i) < mapB.get(i)) result++; // 오류
}

// 2. max 방식은 추월한 차를 정확히 세지 못함
// (뒤에 나온 차 중 A순서가 작은 게 있는지 확인해야 함)
if (orderInA < max) result++; // 잘못된 접근
```

---

## 전체 코드

```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
int N = Integer.parseInt(br.readLine().trim());

HashMap<String, Integer> mapA = new HashMap<>();
for (int i = 0; i < N; i++) {
    mapA.put(br.readLine(), i);
}

String[] arrayB = new String[N];
for (int i = 0; i < N; i++) {
    arrayB[i] = br.readLine();
}

int result = 0;
for (int i = 0; i < N; i++) {
    int orderA_i = mapA.get(arrayB[i]);
    for (int j = i + 1; j < N; j++) {
        int orderA_j = mapA.get(arrayB[j]);
        if (orderA_j < orderA_i) {
            result++;
            break;
        }
    }
}

System.out.println(result);
```

---

## 핵심 정리

| 항목 | 내용 |
|------|------|
| 추월 조건 | B에서 뒤에 나왔는데 A순서가 앞인 차가 존재 |
| 자료구조 | mapA(HashMap) + arrayB(배열) |
| 알고리즘 | 이중 for문 O(N²) |
| 주의 | break 없으면 같은 차를 여러 번 카운트 |
