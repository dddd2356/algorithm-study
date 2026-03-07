# Problem 2750 - 수 정렬하기

[백준 2750번](https://www.acmicpc.net/problem/2750)

## 풀이 요약

버블 정렬을 직접 구현하여 오름차순 정렬 후 출력.

## 코드 리뷰

### 잘된 점

- 버블 정렬 알고리즘을 정확하게 구현
- `arr.length-1-i`로 이미 정렬된 구간을 제외하는 최적화 적용

### 반복 출력에 StringBuilder 권장

```java
for(int i=0; i<N; i++) {
    System.out.println(arr[i]); // N번 반복 출력 → 느림
}
```

N이 최대 1,000이므로 이 문제에서는 큰 차이 없지만 습관적으로 `StringBuilder`를 사용하면 좋다.

```java
StringBuilder sb = new StringBuilder();
for (int i = 0; i < N; i++) sb.append(arr[i]).append('\n');
System.out.print(sb);
```

### Arrays.sort() 활용

정렬 구현이 학습 목적이라면 현재 코드가 좋다. 하지만 실전에서는 `Arrays.sort(arr)`로 O(N log N) 정렬을 바로 사용하는 것이 낫다.

```java
Arrays.sort(arr); // 버블 정렬(O(N²)) 대비 훨씬 빠름
```
