# BOJ 2564 - 경비원

- 난이도: 실버 1
- 유형: 구현, 시뮬레이션

## 문제 요약

W x H 직사각형 블록 둘레 위에 상점들과 경비원이 있다.
경비원에서 각 상점까지의 최단거리 합을 구한다.
둘레 위에서만 이동 가능하며 건물 내부는 통과할 수 없다.

## 핵심 아이디어

직사각형 둘레를 **시계방향으로 펼쳐서 1차원 절대 위치로 변환**

```
(0,0)→→→→→→→(W,0)
  ↑               ↓
  서             동
  ↑               ↓
(0,H)←←←←←←←(W,H)
```

| 방향 | 범위 | 절대 위치 |
|------|------|-----------|
| 북(1) | 0 ~ W | `x` |
| 동(4) | W ~ W+H | `W + x` |
| 남(2) | W+H ~ 2W+H | `2W + H - x` (오른쪽→왼쪽) |
| 서(3) | 2W+H ~ 2W+2H | `2W + 2H - x` (아래→위) |

전체 둘레 = `2 * (W + H)`

## 최단거리 계산

둘레 위 두 점 사이의 경로는 시계방향/반시계방향 두 가지뿐.
상점마다 어느 방향이 더 짧은지 다를 수 있으므로 매번 둘 다 계산하고 선택.

```java
int diff = Math.abs(pos1 - pos2);
int shortest = Math.min(diff, 2*(W+H) - diff);
//                     시계방향    반시계방향
```

## 예시 추적

W=6, H=5, 전체 둘레=22

```
0----2----7-----------14-----------22
     A    경비원        B
```

- 상점A: 북쪽 x=2 → 절대위치 2
- 상점B: 남쪽 x=3 → 절대위치 2*6+5-3 = 14
- 경비원: 동쪽 y=1 → 절대위치 6+1 = 7

경비원 → 상점A:
- 시계방향: |7-2| = 5
- 반시계방향: 22-5 = 17
- 최단 = min(5, 17) = **5**

경비원 → 상점B:
- 시계방향: |7-14| = 7
- 반시계방향: 22-7 = 15
- 최단 = min(7, 15) = **7**

총합 = 5 + 7 = **12**

## 풀이 코드

```java
import java.io.*;
import java.util.*;

public class Main {
    static int W, H;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(br.readLine());
        int[] shops = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            shops[i] = toPos(dir, x);
        }

        st = new StringTokenizer(br.readLine());
        int guardDir = Integer.parseInt(st.nextToken());
        int guardX = Integer.parseInt(st.nextToken());
        int guard = toPos(guardDir, guardX);

        int total = 0;
        for (int shop : shops) {
            int diff = Math.abs(guard - shop);
            total += Math.min(diff, 2 * (W + H) - diff);
        }
        System.out.println(total);
    }

    static int toPos(int dir, int x) {
        if (dir == 1) return x;                  // 북
        if (dir == 2) return 2 * W + H - x;      // 남
        if (dir == 3) return 2 * W + 2 * H - x;  // 서
        return W + x;                             // 동(4)
    }
}
```

## 포인트 정리

- 2D → 1D 변환으로 문제를 단순화
- 남쪽/서쪽은 역방향이라 변환식에서 빼는 형태
- 매번 시계/반시계 둘 다 계산하고 `Math.min`으로 선택
