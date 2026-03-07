# Problem 11724 - 연결 요소의 개수

[백준 11724번](https://www.acmicpc.net/problem/11724)

## 풀이 요약

무방향 그래프에서 DFS로 연결 요소(Connected Component)의 개수를 탐색.

## 코드 리뷰

### 잘된 점

- `BufferedReader` + `StringTokenizer`로 빠른 입력
- DFS 구현이 정확하고 간결함
- 방문 체크를 DFS 내부에서 확인하여 중복 방문 방지

### C스타일 배열 선언

```java
static boolean visited[]; // C 스타일
```

```java
static boolean[] visited; // Java 컨벤션
```

### 제네릭 배열 raw type 경고

```java
A = new ArrayList[n+1]; // raw type 경고 발생
```

Java에서 제네릭 배열을 직접 생성할 수 없어 이 방법이 흔히 쓰이지만, `@SuppressWarnings("unchecked")`를 붙이거나 `List<List<Integer>>`를 사용하면 경고를 제거할 수 있다.

### 재귀 DFS 스택 오버플로우 위험

N이 최대 1,000이므로 이 문제에서는 안전하지만, 노드 수가 수만~수십만이면 재귀 DFS가 스택 오버플로우를 일으킬 수 있다. 큰 입력에서는 반복문 기반 DFS나 BFS로 전환하는 것이 좋다.

### DFS 내부 중복 체크

```java
private static void DFS(int v) {
    if(visited[v]) return; // main에서 이미 !visited[i] 체크 후 호출하므로 불필요
```

`main`에서 `!visited[i]` 조건으로 호출하므로 첫 진입 시 이 체크는 불필요하다. 단, 재귀 내부 호출(`DFS(i)`)에서는 필요하다. 로직상 문제는 없지만, 구조를 통일하려면 한쪽에서만 체크하는 방식으로 정리할 수 있다.
