# Problem 16926 - 배열 돌리기 1

[백준 16926번](https://www.acmicpc.net/problem/16926)

## 풀이 요약

NxM 배열을 반시계 방향으로 R번 회전. 레이어별로 테두리 원소를 추출하여 `R % len`만큼 시프트 후 재삽입.

## 코드 리뷰

### 잘된 점

- `R % len`으로 불필요한 반복 회전 제거
- `bottom > top`, `right > left` 조건으로 1행/1열 레이어 중복 삽입 방지
- 출력 시 `StringBuilder` 사용

### 개선 포인트

**입력에 Scanner 사용**

2D 배열 입력이므로 `BufferedReader` + `StringTokenizer`를 사용하면 더 빠르다.

**ArrayList 대신 int[] 사용**

레이어 크기를 미리 계산할 수 있으므로 `ArrayList` 대신 `int[]`를 쓰면 오토박싱 오버헤드와 GC 부담을 줄일 수 있다.

```java
int len = 2 * (bottom - top) + 2 * (right - left);
int[] vals = new int[len];
```

**`rotated` 리스트 불필요**

새 리스트를 만드는 대신 인덱스 계산으로 바로 배열에 쓸 수 있다.

```java
for (int j = left; j <= right; j++) arr[top][j] = vals[(idx++ + rotate) % len];
```
