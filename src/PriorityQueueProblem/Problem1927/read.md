# 백준 1927 - 최소 힙

## 문제 요약

- x > 0 : 배열에 x 삽입
- x = 0 : **가장 작은 값** 출력 후 제거 (비어있으면 0 출력)

---

## 핵심: PriorityQueue 기본값 = 최소 힙

```java
PriorityQueue<Integer> pq = new PriorityQueue<>();
```

Java의 PriorityQueue는 **기본이 최소 힙**이므로 Comparator 없이 그냥 쓰면 된다.
`poll()` 시 자동으로 가장 작은 값이 나온다.

| 문제 | 힙 종류 | Comparator |
|------|---------|------------|
| 1927 (최소 힙) | 최소 힙 | 불필요 (기본값) |
| 11279 (최대 힙) | 최대 힙 | `Collections.reverseOrder()` |
| 11286 (절댓값 힙) | 커스텀 | 람다로 직접 구현 |

---

## 코드 리뷰

```java
PriorityQueue<Integer> pq = new PriorityQueue<>(); // 최소 힙 ✓
Scanner sc = new Scanner(System.in);
int x = sc.nextInt();
for(int i=0; i<x; i++){
    int a = sc.nextInt();
    if(a==0){
        if(pq.isEmpty()){
            System.out.println(0);     // 빈 힙 처리 ✓
        }
        else {
            System.out.println(pq.poll()); // 최솟값 꺼내기 ✓
        }
    }
    else
        pq.add(a); // 0은 넣지 않고 양수만 삽입 ✓
}
```

### 잘된 점

- `if/else` 분리로 0이 힙에 삽입되지 않음 ✓
- 빈 힙 체크 후 0 출력 처리 ✓
- 별도 Comparator 없이 기본 최소 힙 활용 ✓

### 개선 가능한 점: 입출력 성능

N이 최대 100,000이므로 `Scanner` + `System.out.println` 반복은 느릴 수 있다.
`BufferedReader` + `StringBuilder` 조합으로 개선 가능.

```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
StringBuilder sb = new StringBuilder();

int x = Integer.parseInt(br.readLine());
for(int i=0; i<x; i++){
    int a = Integer.parseInt(br.readLine());
    if(a==0){
        sb.append(pq.isEmpty() ? 0 : pq.poll()).append('\n');
    } else {
        pq.add(a);
    }
}
System.out.print(sb);
```

---

## 1927 vs 11279 vs 11286 정리

| | 1927 | 11279 | 11286 |
|--|------|-------|-------|
| 꺼내는 기준 | 최솟값 | 최댓값 | 절댓값 최솟값 (동점 시 음수 우선) |
| Comparator | 기본값 | `reverseOrder()` | 커스텀 람다 |
| 난이도 | 쉬움 | 보통 | 보통 |
