# BOJ 1244 - 스위치 켜고 끄기

- 난이도: 실버 4
- 유형: 구현, 시뮬레이션

## 문제 요약

n개의 스위치가 있고 학생들이 순서대로 스위치를 조작한다.
- **남학생(1)**: 자신의 번호의 배수에 해당하는 스위치를 모두 토글
- **여학생(2)**: 자신의 번호를 중심으로 좌우 대칭인 구간의 스위치를 모두 토글

## 핵심 로직

### 남학생
```
location = 3이면 3, 6, 9, 12... 번 스위치 토글
인덱스 기준: location-1부터 location씩 증가
```
```java
for (int j = location - 1; j < n; j += location) {
    switches[j] ^= 1;
}
```

### 여학생
```
location = 5이면 5번 중심으로
좌우가 같은 값인 동안 확장: [4,6], [3,7], [2,8]... 토글
```
```java
switches[location - 1] ^= 1;  // 자신 먼저 토글
int left = location - 2;
int right = location;
while (left >= 0 && right < n && switches[left] == switches[right]) {
    switches[left] ^= 1;
    switches[right] ^= 1;
    left--;
    right++;
}
```

## 출력 형식 주의

20개씩 줄바꿈, 숫자 사이 공백 하나

```java
StringBuilder sb = new StringBuilder();
for (int i = 0; i < n; i++) {
    if (i > 0 && i % 20 == 0) sb.append('\n');
    else if (i > 0) sb.append(' ');
    sb.append(switches[i]);
}
System.out.println(sb);
```

## 전체 풀이 코드

```java
package Simulation.Problem1244;

import java.util.Scanner;

public class Problem1244 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] switches = new int[n];
        for (int i = 0; i < n; i++) {
            switches[i] = sc.nextInt();
        }
        int person = sc.nextInt();
        for (int i = 0; i < person; i++) {
            int star = sc.nextInt();
            int location = sc.nextInt();

            if (star == 1) {
                for (int j = location - 1; j < n; j += location) {
                    switches[j] ^= 1;
                }
            } else if (star == 2) {
                switches[location - 1] ^= 1;
                int left = location - 2;
                int right = location;
                while (left >= 0 && right < n && switches[left] == switches[right]) {
                    switches[left] ^= 1;
                    switches[right] ^= 1;
                    left--;
                    right++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i > 0 && i % 20 == 0) sb.append('\n');
            else if (i > 0) sb.append(' ');
            sb.append(switches[i]);
        }
        System.out.println(sb);
    }
}
```

## 포인트 정리

- 남학생: `j += location` (배수마다 토글)
- 여학생: 중심 먼저 토글 후 좌우 확장, **좌우 값이 같은 동안만** 확장
- `switches[j] ^= 1` 로 토글 간결하게 표현
- `sc.nextLine()` 남용 주의 - nextInt()끼리는 자동으로 공백/줄바꿈 건너뜀
