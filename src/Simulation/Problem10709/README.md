# BOJ 10709 - 기상캐스터

- 난이도: 실버 5
- 유형: 구현, 시뮬레이션

## 문제 요약

H x W 격자가 주어진다. 구름(`c`)은 매 시간 오른쪽으로 한 칸씩 이동한다.
각 칸에 구름이 처음 도달하는 시간을 출력하고, 구름이 올 수 없으면 -1을 출력한다.

## 핵심 관찰

- 구름은 좌우로만 이동 → **각 행을 독립적으로 처리**
- 왼쪽에서 오른쪽으로 스캔하며 `c`를 만나면 `lastCloud = j` 갱신
- 현재 칸의 답 = `j - lastCloud`
- 왼쪽에 구름이 없으면 (`lastCloud == -1`) → `-1`

## 예시 추적

### 입력
```
3 9
.c.......
c........
.........
```

### 1행: `.c.......`

| j | 문자 | lastCloud | 계산 | 결과 |
|---|------|-----------|------|------|
| 0 | `.` | -1 | lastCloud=-1 | -1 |
| 1 | `c` | 1 | lastCloud 갱신 → 1-1 | 0 |
| 2 | `.` | 1 | 2-1 | 1 |
| 3 | `.` | 1 | 3-1 | 2 |
| 4 | `.` | 1 | 4-1 | 3 |
| 5 | `.` | 1 | 5-1 | 4 |
| 6 | `.` | 1 | 6-1 | 5 |
| 7 | `.` | 1 | 7-1 | 6 |
| 8 | `.` | 1 | 8-1 | 7 |

→ `-1 0 1 2 3 4 5 6 7`

### 2행: `c........`

| j | 문자 | lastCloud | 계산 | 결과 |
|---|------|-----------|------|------|
| 0 | `c` | 0 | lastCloud 갱신 → 0-0 | 0 |
| 1~8 | `.` | 0 | j-0 | 1~8 |

→ `0 1 2 3 4 5 6 7 8`

### 3행: `.........`

왼쪽에 구름이 없으므로 전부 `-1`

→ `-1 -1 -1 -1 -1 -1 -1 -1 -1`

### 구름이 여러 개인 경우: `.c...c...`

| j | 문자 | lastCloud | 계산 | 결과 |
|---|------|-----------|------|------|
| 0 | `.` | -1 | | -1 |
| 1 | `c` | 1 | 1-1 | 0 |
| 2~4 | `.` | 1 | j-1 | 1~3 |
| 5 | `c` | 5 | lastCloud 갱신 → 5-5 | 0 |
| 6~8 | `.` | 5 | j-5 | 1~3 |

→ `-1 0 1 2 3 0 1 2 3`

두 번째 구름을 만나면 `lastCloud`가 갱신되어 더 가까운 구름 기준으로 자동 재계산된다.

## 풀이 코드

```java
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < H; i++) {
            String line = br.readLine();
            int lastCloud = -1;  // 가장 최근 구름의 열 위치

            for (int j = 0; j < W; j++) {
                if (line.charAt(j) == 'c') {
                    lastCloud = j;  // 구름 위치 갱신
                }

                if (lastCloud == -1) {
                    sb.append(-1);            // 왼쪽에 구름이 없음
                } else {
                    sb.append(j - lastCloud); // 구름이 도달하는 데 걸리는 시간
                }

                if (j < W - 1) sb.append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
```

## 포인트 정리

- 2D 배열 전체를 시뮬레이션하지 않아도 된다
- 각 행에서 `lastCloud`만 추적하면 O(H x W)로 해결
- `StringBuilder` 사용으로 출력 속도 최적화
