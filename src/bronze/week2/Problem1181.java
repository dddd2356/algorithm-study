package bronze.week2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Problem1181 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] str = new String[N];
        sc.nextLine();
        for(int i=0; i< str.length; i++){
            str[i] = sc.nextLine();
        }
        Object[] result = null;
        result = Arrays.stream(str)
                .distinct() // 중복 제거
                .sorted((Comparator.comparingInt(String::length)
                        .thenComparing(String::compareTo)))   // 길이 짧은 것 부터 오름차순 정렬
                .toArray(); // 배열로 변환
        for(int i=0; i<result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
