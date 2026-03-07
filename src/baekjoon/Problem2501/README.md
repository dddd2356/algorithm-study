# Problem 2501 - 약수 구하기

[백준 2501번](https://www.acmicpc.net/problem/2501)

## 풀이 요약

N의 약수를 오름차순으로 나열했을 때 K번째 약수를 출력. 약수가 K개 미만이면 0 출력.

## 코드 리뷰

### 버그

**K번째 약수가 없을 때 예외 발생**

```java
System.out.println(result[q-1]);  // q > 약수 개수이면 ArrayIndexOutOfBoundsException
```

문제 조건상 약수가 K개 미만이면 0을 출력해야 하지만, 현재 코드는 예외를 던진다.
`j < q`인 경우 `0`을 출력하는 처리가 필요하다.

```java
System.out.println(j < q ? 0 : result[q - 1]);
```

### 불필요한 조건

```java
if(p/i>0 && p%i==0)  // p/i > 0 은 항상 true (i가 1~p 범위이므로)
```

`p / i > 0` 조건은 `i`가 `1`부터 `p`까지 순회하므로 항상 성립한다. `p % i == 0`만으로 충분하다.

```java
if(p % i == 0)
```

### 메모리 낭비

```java
int[] result = new int[p];  // 최대 1000칸 할당, 실제 약수 수는 훨씬 적음
```

약수 개수는 N보다 훨씬 적다. K번째 약수를 구하는 목적이라면 배열 없이 카운터로 해결 가능하다.

```java
int count = 0;
for (int i = 1; i <= p; i++) {
    if (p % i == 0) {
        count++;
        if (count == q) {
            System.out.println(i);
            return;
        }
    }
}
System.out.println(0);
```

### 입출력 속도

`Scanner` 대신 `BufferedReader`를 사용하면 입출력 속도가 향상된다. 이 문제는 입력이 적어 큰 차이가 없지만 습관적으로 적용하는 것이 좋다.
