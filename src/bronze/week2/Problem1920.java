package bronze.week2;

import java.util.HashSet;
import java.util.Scanner;

//시간 초과로 인해 HashSet을 이용하여 비교.
public class Problem1920 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // 1. 첫 번째 입력: N (arr1의 크기)
        int N = sc.nextInt();

        // 2. N개의 수를 HashSet에 저장
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<N; i++){
            set.add(sc.nextInt());
        }

        // 3. 두 번째 입력: M (arr2의 크기)
        int M = sc.nextInt();

        // 4. M개의 수를 하나씩 읽으면서 set에 있는지 확인
        for(int i=0; i<M; i++){
            int target = sc.nextInt();
            if (set.contains(target)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}