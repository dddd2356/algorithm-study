# BOJ 14425 - 문자열 집합

## 문제 요약
N개의 문자열로 이루어진 집합 S가 주어질 때,
M개의 문자열 중 S에 속하는 문자열의 개수를 출력.

## 풀이 흐름
1. N개의 문자열을 자료구조에 저장
2. M개의 문자열을 하나씩 읽으며 저장된 집합에 포함되는지 확인
3. 포함되면 카운트 증가

## 현재 코드의 문제점
```java
ArrayList<String> arrA = new ArrayList<>();
...
if(arrA.contains(arrB.get(i))) { ... }
```
`ArrayList.contains()`는 **O(N)** 탐색 → M번 반복하면 **O(N*M)**

N, M 최대 10,000이므로 최악 1억 번 연산 → **시간 초과 위험**

## 권장 풀이: HashSet 사용
```java
HashSet<String> set = new HashSet<>();
for(int i=0; i<N; i++) set.add(br.readLine());

int result = 0;
for(int i=0; i<M; i++){
    if(set.contains(br.readLine())) result++;
}
System.out.println(result);
```
`HashSet.contains()`는 **O(1)** → 전체 **O(N+M)**

## 자료구조 비교
| 자료구조 | contains 시간복잡도 | 적합 여부 |
|----------|-------------------|----------|
| ArrayList | O(N) | 비적합 (느림) |
| HashSet | O(1) | **적합** |

## 난이도
**실버 4** (BOJ 기준)

HashSet의 존재를 알면 매우 쉬운 문제.
모르면 ArrayList로 풀었다가 시간 초과를 맞을 수 있음.
→ **"시간 초과 나면 HashSet을 떠올려라"** 를 배우는 문제.
