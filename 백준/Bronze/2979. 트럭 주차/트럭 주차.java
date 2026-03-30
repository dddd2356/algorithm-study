import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int[] cnt = new int[100];
        int result=0;
        sc.nextLine();
        for(int i=0; i<3; i++){
            int a= sc.nextInt();
            int b= sc.nextInt();
            for(int j=a; j<b; j++){
                cnt[j]++;
            }
        }
        for(int i=0; i<cnt.length; i++){
            if(cnt[i]==1){
                result+=A;
            }
            else if(cnt[i]==2){
                result+=B*2;
            }
            else if(cnt[i]==3){
                result+=C*3;
            }
        }
        System.out.println(result);
    }
}