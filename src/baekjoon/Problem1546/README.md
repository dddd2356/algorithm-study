# Problem 1546 - 평균

[백준 1546번](https://www.acmicpc.net/problem/1546)

## 풀이 요약

최고점을 M으로 두고, 각 점수를 `score / M * 100`으로 변환한 뒤 평균을 출력.

## 코드 리뷰

### 버그 - float 정밀도 손실

```java
float max = 0;
float sum = 0;
```

`float`은 유효 자릿수가 약 7자리로, 큰 값이나 많은 합산에서 정밀도 오류가 발생할 수 있다. `double`을 사용해야 한다.

```java
double max = 0;
double sum = 0;
```

### 불필요한 `sc.nextLine()`

```java
int N = sc.nextInt();
// ...
sc.nextLine(); // nextInt() 이후 줄바꿈 소비 목적
for(int i=0; i<N; i++){
    num[i]=sc.nextInt(); // nextInt()는 공백/줄바꿈 자동 스킵 - nextLine() 불필요
```

`nextInt()`는 이후 줄바꿈을 자동으로 건너뛰므로 `sc.nextLine()` 호출이 불필요하다. (단, 이후에 `nextLine()`으로 문자열을 읽는 경우라면 필요)

### 중괄호 생략

```java
if(max<num[i])
    max = num[i]; // 중괄호 없음
```

단일 구문이라도 중괄호를 추가하는 것이 안전하다.

### 입출력 속도

`Scanner` 대신 `BufferedReader`를 사용하면 더 빠르다.
