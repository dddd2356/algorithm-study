package silver.week3;

import java.util.Scanner;

public class Problem1003 {

    //DP란? 큰 문제를 작은 문제로 나누고, 계산한 작은 문제의 해를 저장해두어 중복 계산을 피하는 방법.

    //DP로 미리 구현한다 = 입력 가능한 모든 n에 대해 미리 배열에 값들을 채워둔 뒤 테스트케이스에서 꺼내쓴다는 의미.

    //피보나치 함수 문제는 DP 점화식 그대로라서 전형적인 DP 예제임.
    static int[][] dp = new int[41][2]; // n은 40 이하

    static void init() {
        dp[0][0] = 1; dp[0][1] = 0; // fibonacci(0)
        dp[1][0] = 0; dp[1][1] = 1; // fibonacci(1)
        for (int i = 2; i <= 40; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-2][0]; // zero 개수
            dp[i][1] = dp[i-1][1] + dp[i-2][1]; // one 개수
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        init();

        for (int t = 0; t < T; t++) {
            int n = sc.nextInt();
            System.out.println(dp[n][0] + " " + dp[n][1]);
        }
    }

    //    static int zeroCount = 0;
//    static int oneCount = 0;
//    static int fibonacci(int n){
//        if (n == 0) {
//            zeroCount++;
//            return 0;
//        } else if (n == 1) {
//            oneCount++;
//            return 1;
//        } else {
//            return fibonacci(n-1) + fibonacci(n-2);
//        }
//    }
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt();
//        int n = 0;
//        for(int i=0; i<T; i++){
//            n = sc.nextInt();
//            zeroCount = 0;
//            oneCount = 0;
//            fibonacci(n);
//            System.out.println(zeroCount + " " + oneCount);
//        }
//    }

}
