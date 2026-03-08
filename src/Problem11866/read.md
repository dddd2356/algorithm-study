# 백준 11866 - 요세푸스 문제 0

## 문제 요약

- N명이 원형으로 앉아있음
- K번째 사람을 제거하고 출력
- 모든 사람이 제거될 때까지 반복
- 출력 형식: `<3, 6, 2, 7, 5, 1, 4>`

---

## 핵심 자료구조: Queue (LinkedList)

이 문제는 **PriorityQueue가 아닌 일반 Queue**를 사용한다.
원형 구조를 Queue로 시뮬레이션하는 것이 핵심.

---

## 핵심 코드: queue.add(queue.poll())

```java
queue.add(queue.poll());
```

앞에서 꺼내서(poll) 뒤에 붙이는(add) 동작.
이걸 K-1번 반복하면 K번째 사람이 맨 앞으로 온다.

```
Queue: [1, 2, 3, 4, 5, 6, 7],  K=3

queue.add(queue.poll()) → 1을 꺼내 뒤로: [2, 3, 4, 5, 6, 7, 1]
queue.add(queue.poll()) → 2를 꺼내 뒤로: [3, 4, 5, 6, 7, 1, 2]
K-1번(2번) 반복 완료 → 맨 앞이 K번째 사람(3)
queue.poll() → 3 제거 및 출력
```

원형으로 앉은 구조를 Queue의 앞→뒤 순환으로 표현한 것.

---

## 전체 흐름 예시

N=7, K=3

```
초기: [1, 2, 3, 4, 5, 6, 7]

1라운드: 1→뒤, 2→뒤, 3→제거   출력: 3  남은: [4, 5, 6, 7, 1, 2]
2라운드: 4→뒤, 5→뒤, 6→제거   출력: 6  남은: [7, 1, 2, 4, 5]
3라운드: 7→뒤, 1→뒤, 2→제거   출력: 2  남은: [4, 5, 7, 1]
4라운드: 4→뒤, 5→뒤, 7→제거   출력: 7  남은: [1, 4, 5]
5라운드: 1→뒤, 4→뒤, 5→제거   출력: 5  남은: [1, 4]
6라운드: 1→뒤, 4→뒤, 1→제거   출력: 1  남은: [4]
7라운드: 4→뒤, 4→뒤, 4→제거   출력: 4  남은: []

결과: <3, 6, 2, 7, 5, 1, 4>
```

---

## 코드

```java
import java.util.*;

public class Problem11866 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(); // N: 사람 수
        int b = sc.nextInt(); // K: K번째 제거

        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=a; i++)
            queue.add(i);

        StringBuilder sb = new StringBuilder("<");
        while(!queue.isEmpty()){
            for(int i=0; i<b-1; i++)
                queue.add(queue.poll()); // K-1번 앞에서 꺼내 뒤로
            sb.append(queue.poll());     // K번째 제거 후 출력
            if(!queue.isEmpty()) sb.append(", ");
        }
        sb.append(">");
        System.out.println(sb);
    }
}
```

---

## PriorityQueue vs Queue 비교

| | Queue (LinkedList) | PriorityQueue |
|--|-------------------|---------------|
| 꺼내는 기준 | 먼저 들어온 것 (FIFO) | 우선순위 높은 것 |
| 이 문제에서 | 순서 유지가 필요 → Queue | 우선순위 불필요 |
| 사용 상황 | 순서/순환 시뮬레이션 | 최솟값/최댓값 반복 추출 |

---

## 초기 코드 문제점

```java
int[] A = new int[a];
for(int i=0; i<a; i++){
    A[i]=i+1; // 배열만 만들고 로직 없음
}
// K번째 제거 로직 전혀 없음
```

배열로는 원형 순환 구조를 표현하기 어렵다.
Queue를 쓰면 `add(poll())`로 순환을 간단하게 구현할 수 있다.
