package bronze.week2;

import java.util.Scanner;

public class Problem10809 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        for (char c = 'a'; c <= 'z'; c++) {
            int index = s.indexOf(c); // 문자열에서 처음 나오는 위치
            System.out.print(index + " ");
        }
    }
}
