# BOJ 1063 - 킹

- 난이도: 실버 4
- 유형: 구현, 시뮬레이션

## 문제 요약

체스판(8x8)에서 킹과 돌이 있다.
킹이 이동할 때 돌이 있으면 돌도 같은 방향으로 밀려난다.
킹 또는 돌이 체스판 밖으로 나가면 그 이동은 무시한다.

## 핵심 로직

이동 순서:
1. 킹의 다음 위치 계산
2. 킹이 범위 밖 → 무시
3. 킹의 다음 위치 == 돌 위치 → 돌도 같은 방향으로 이동
4. 돌이 범위 밖 → 무시
5. 둘 다 괜찮으면 → 이동

```java
// 킹이 범위 밖이면 무시
if (nkx < 0 || nkx > 7 || nky < 0 || nky > 7) continue;

// 킹이 돌 위치로 이동하는 경우
if (nkx == sx && nky == sy) {
    int nsx = sx + d[0];
    int nsy = sy + d[1];

    // 돌이 범위 밖으로 나가면 무시
    if (nsx < 0 || nsx > 7 || nsy < 0 || nsy > 7) continue;

    sx = nsx;
    sy = nsy;
}

kx = nkx;
ky = nky;
```

## 좌표 변환

문자 좌표 → 숫자로 변환해서 처리

```
'A'~'H' → 0~7  (열)
'1'~'8' → 0~7  (행)
```

## 방향 정의

| 입력 | dx | dy |
|------|----|----|
| R  |  1 |  0 |
| L  | -1 |  0 |
| T  |  0 |  1 |
| B  |  0 | -1 |
| RT |  1 |  1 |
| LT | -1 |  1 |
| RB |  1 | -1 |
| LB | -1 | -1 |

## 풀이 코드

```java
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String kingPos = st.nextToken();
        String stonePos = st.nextToken();
        int n = Integer.parseInt(st.nextToken());

        int kx = kingPos.charAt(0) - 'A';
        int ky = kingPos.charAt(1) - '1';
        int sx = stonePos.charAt(0) - 'A';
        int sy = stonePos.charAt(1) - '1';

        Map<String, int[]> dir = new HashMap<>();
        dir.put("R",  new int[]{ 1,  0});
        dir.put("L",  new int[]{-1,  0});
        dir.put("B",  new int[]{ 0, -1});
        dir.put("T",  new int[]{ 0,  1});
        dir.put("RT", new int[]{ 1,  1});
        dir.put("LT", new int[]{-1,  1});
        dir.put("RB", new int[]{ 1, -1});
        dir.put("LB", new int[]{-1, -1});

        for (int i = 0; i < n; i++) {
            int[] d = dir.get(br.readLine().trim());
            int nkx = kx + d[0];
            int nky = ky + d[1];

            if (nkx < 0 || nkx > 7 || nky < 0 || nky > 7) continue;

            if (nkx == sx && nky == sy) {
                int nsx = sx + d[0];
                int nsy = sy + d[1];

                if (nsx < 0 || nsx > 7 || nsy < 0 || nsy > 7) continue;

                sx = nsx;
                sy = nsy;
            }

            kx = nkx;
            ky = nky;
        }

        System.out.println((char)(kx + 'A') + "" + (char)(ky + '1'));
        System.out.println((char)(sx + 'A') + "" + (char)(sy + '1'));
    }
}
```

## 포인트 정리

- 이동 전 반드시 킹 → 돌 순서로 범위 체크
- 돌 범위 체크는 킹과 돌이 겹칠 때만 수행
- 문자 좌표를 숫자로 변환하면 범위 체크가 편함
