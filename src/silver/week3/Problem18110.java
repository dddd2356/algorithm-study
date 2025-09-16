package silver.week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// 문제: 의견 점수 중 위 15%, 아래 15%를 제거하고 평균 점수 구하기
// Scanner 대신 BufferedReader 사용 → 입력이 많으면 Scanner는 느려서 시간초과 발생 가능
public class Problem18110 {
    public static void main(String[] args) throws Exception {
        // BufferedReader로 한 줄씩 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 줄: 의견 개수 n
        int n = Integer.parseInt(br.readLine());

        // 의견이 없는 경우 0 출력 후 종료
        if(n == 0) {
            System.out.println(0);
            return;
        }

        // 점수 저장 배열
        int[] a = new int[n];
        int idx = 0;

        // 반복해서 모든 점수를 읽음
        // 한 줄에 여러 점수가 들어올 수도 있으므로 split 사용
        while(idx < n) {
            String[] parts = br.readLine().split(" "); // 공백 기준으로 나눔
            for(String s : parts) {
                if(s.isEmpty()) continue;              // 빈 문자열은 무시
                a[idx++] = Integer.parseInt(s);       // 문자열 → 정수 변환 후 배열에 저장
                if(idx == n) break;                   // n개 읽으면 종료
            }
        }

        // 점수 정렬 → 위/아래 15% 제거를 위해 필요
        Arrays.sort(a);

        // 잘라낼 개수 = 전체의 15%, 반올림
        int trim = (int)Math.round(n * 0.15);

        // 잘라낸 뒤 남은 점수 합계
        long sum = 0;
        for(int i = trim; i < n - trim; i++) sum += a[i];

        // 남은 점수 개수
        int count = n - 2*trim;

        // 평균 계산 후 소수점 반올림
        System.out.println(Math.round((double)sum / count));
    }
}