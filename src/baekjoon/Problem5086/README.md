# Problem 5086 - 배수와 약수

[백준 5086번](https://www.acmicpc.net/problem/5086)

## 풀이 요약

a와 b를 입력받아 a가 b의 약수면 "factor", a가 b의 배수면 "multiple", 그 외엔 "neither" 출력. `0 0` 입력 시 종료.

## 코드 리뷰

### 불필요한 조건

```java
} else if (a / b > 0 && a % b == 0) {
```

`a / b > 0`은 `a >= b`를 검사하는 의도로 보이지만, 이 조건은 불필요하다.

- `a % b == 0`이면 `a`는 `b`의 배수다 (a < b인 경우 a가 0일 때만 성립하는데, 입력에서 0은 종료 신호라 실질적으로 문제 없음).
- `a / b > 0` 조건은 코드의 의도를 모호하게 만든다.

```java
} else if (a % b == 0) {
    System.out.println("multiple");
}
```

### 중괄호 생략

```java
} else
    System.out.println("neither");
```

`else` 블록에 중괄호가 없다. 나중에 구문을 추가할 때 버그가 생길 수 있으므로 항상 중괄호를 사용하는 것이 좋다.

```java
} else {
    System.out.println("neither");
}
```

### 입출력 속도

반복 입출력이 있으므로 `BufferedReader` + `StringTokenizer` 조합을 사용하면 더 빠르다.

```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
StringBuilder sb = new StringBuilder();
StringTokenizer st;

while (true) {
    st = new StringTokenizer(br.readLine());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    if (a == 0 && b == 0) break;
    if (b % a == 0) sb.append("factor\n");
    else if (a % b == 0) sb.append("multiple\n");
    else sb.append("neither\n");
}
System.out.print(sb);
```
