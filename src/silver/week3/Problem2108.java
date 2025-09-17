package silver.week3;

import java.util.Arrays;
import java.util.Scanner;

public class Problem2108 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] a= new int[N];
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++){
            a[i] = sc.nextInt();
            sum += a[i];
            min = Math.min(min, a[i]);
            max = Math.max(max, a[i]);
        }
        Arrays.sort(a);

        int range = max-min;

        double avg=0;
        int mid = 0;
        int maxCount = 0;
        int firstIndex = -1;
        int secondIndex = -1;
        int answer = 0;
        // 최빈값 계산을 위한 offset
        int offset = -min; // 배열 인덱스를 0 이상으로 맞추기
        int[] freq = new int[max + offset + 1];
        if(a.length % 2 ==0) {
            mid = a[(N / 2)-1];
        }
        else {
            mid = a[(N / 2)];
        }
        for(int num : a){
            freq[num + offset]++;
        }
        // 최빈값 구하기
        // 즉 가장 높은 빈도수를 가진 값을 찾고, 이 값을 answer에 저장
        for(int i = 0; i < freq.length; i++){
            if(freq[i] > maxCount){
                maxCount = freq[i];
                firstIndex = i;
                secondIndex = -1;
            } else if(freq[i] == maxCount){
                if(firstIndex != -1 && secondIndex == -1){
                    secondIndex = i;
                }
            }
        }

        // 결과 반환
        if (secondIndex != -1) {
            answer = secondIndex - offset; // 최빈값 두 번째
        } else {
            answer = firstIndex - offset;  // 최빈값 한 개만 있을 때
        }

        avg = Math.round((double) sum /N);
        System.out.println((int)avg);
        System.out.println(mid);
        System.out.println(answer);
        System.out.println(range);
    }
}
