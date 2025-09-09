package bronze.week2;

import java.util.Arrays;
import java.util.Scanner;

public class Problem11650 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

// x 오름차순, x 같으면 y 오름차순
        Arrays.sort(arr, (p1, p2) -> {
            if (p1[0] != p2[0]) return p1[0] - p2[0];
            else return p1[1] - p2[1];
        });

        for (int i = 0; i < N; i++) {
            System.out.println(arr[i][0] + " " + arr[i][1]);
        }
    }
}
