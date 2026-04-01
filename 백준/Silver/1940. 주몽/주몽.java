import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int m = sc.nextInt();
        int[] a = new int[n];
        for(int i=0; i<a.length; i++){
            a[i]=sc.nextInt();
        }
        int cnt = 0;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(a[i]+a[j] == m)
                    cnt++;
            }
        }
        System.out.println(cnt);
    }
}