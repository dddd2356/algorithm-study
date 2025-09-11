package bronze.week2;

import java.util.Scanner;

public class Problem7568 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][2];
        int[] rank = new int[N];
        int k=1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i<arr.length; i++) {
            k=1;
            for(int j=0; j<arr.length;j++) {
                if (arr[i][0] > arr[j][0] && arr[i][1] > arr[j][1]) {
                   continue;
                } else if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
                    k++;
                } else
                    continue;
            }
            rank[i]=k;
        }
        for(int i=0; i<rank.length; i++){
            System.out.print(rank[i] + " ");
        }
    }
}
