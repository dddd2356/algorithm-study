package bronze.week2;

import java.util.Scanner;

public class Problem2798 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int[] c = new int[a];
        int max = 0;
        for(int i=0; i<a; i++){
            c[i] = sc.nextInt();
        }
        for(int i=0; i<a; i++){
            for(int j=1; j<a; j++) {
                for (int z = 2; z < a; z++) {
                    int d = c[i]+c[j]+c[z];
                    if (b >= d && i!=j && j!=z && z!=i) {
                        if (max < d)
                            max = d;
                    }
                }
            }
        }
        System.out.println(max);
    }
}
