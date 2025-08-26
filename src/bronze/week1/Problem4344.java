package bronze.week1;

import java.util.Scanner;

public class Problem4344 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();   // 테스트 케이스 개수 입력
        for(int i=0;i<n;i++) {     // 각 테스트 케이스 반복
            int a=scanner.nextInt();   // 학생 수 입력
            int sum=0;                 // 점수 총합
            int count=0;               // 평균 넘는 학생 수
            double avg[]=new double[a]; // 학생 점수 배열
            // 점수 입력받으면서 총합 구하기
            for(int j=0;j<a;j++) {
                avg[j] = scanner.nextInt();
                sum += avg[j];
            }
            sum=sum/a;
            // 평균 넘는 학생 수 세기
            for(int j=0;j<a;j++) {
                if(sum<avg[j]) {
                    count++;
                }
            }
            // 비율 출력 (소수점 셋째 자리까지)
            System.out.printf("%.3f",(double)count/a*100);
            System.out.println("%");
        }
    }
}