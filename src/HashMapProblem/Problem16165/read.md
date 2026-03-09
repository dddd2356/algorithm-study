# BOJ 16165 - 걸그룹 마스터 준석이

## 문제 요약
N개의 걸그룹과 각 멤버 정보를 저장한 뒤, M개의 퀴즈에 답하는 문제.

- **퀴즈 타입 0**: 멤버 이름 → 그룹 이름 출력 (사전순으로 앞선 그룹)
- **퀴즈 타입 1**: 그룹 이름 → 멤버 전원 출력 (사전순)

## 자료구조
```
HashMap<String, ArrayList<String>>
  키: 그룹명
  값: 멤버 리스트
```

## 풀이 흐름
1. 그룹명을 키, 멤버 리스트를 값으로 HashMap에 저장
2. 퀴즈 타입에 따라 분기

### 퀴즈 0 (멤버 → 그룹)
- 그룹명 리스트를 **사전순 정렬**
- 각 그룹의 멤버 리스트에 해당 멤버가 있으면 그룹명 출력 후 break

### 퀴즈 1 (그룹 → 멤버)
- HashMap에서 그룹명으로 멤버 리스트 직접 조회
- **사전순 정렬** 후 한 명씩 출력

## 핵심 코드
```java
if(quiz == 0) {
    Collections.sort(result); // 그룹명 사전순 정렬
    for(String group : result) {
        if(groupMap.get(group).contains(s)) {
            System.out.println(group);
            break;
        }
    }
} else {
    ArrayList<String> members = groupMap.get(s);
    Collections.sort(members); // 멤버 사전순 정렬
    for(String m : members) System.out.println(m);
}
```

## 자주 하는 실수
| 실수 | 설명 |
|------|------|
| quiz 타입 혼동 | 0과 1이 헷갈려서 로직 반대로 작성 |
| 불필요한 루프 | else 블록에 바깥 for문 추가해서 멤버가 N번 출력됨 |
| 정렬 누락 | 그룹명 리스트 정렬 안 하면 사전순 보장 안 됨 |

## 난이도
**실버 5** (BOJ 기준)

체감 난이도는 낮지 않음. 자료구조 선택은 간단하지만:
- HashMap + ArrayList 조합 익숙하지 않으면 헷갈림
- 퀴즈 타입별 정렬 기준이 달라 실수하기 쉬움
- Scanner의 nextInt() / nextLine() 혼용 시 개행 문자 문제 발생 가능
