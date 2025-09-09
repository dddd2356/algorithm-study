package bronze.week2;

import java.util.Scanner;
//5!이 증가할 때마다 끝자리 0의 개수가 1씩 증가함.
public class Problem1676 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int num = in.nextInt();
        int count = 0;

        while (num >= 5) {
            count += num / 5;
            num /= 5;
        }
        System.out.println(count);
    }
}