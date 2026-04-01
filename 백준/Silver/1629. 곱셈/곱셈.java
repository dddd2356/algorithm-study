import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Main {
    static long A;
    static long B;
    static long C;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        StringTokenizer st = new StringTokenizer(num);
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        System.out.println(go(A,B));
    }

    static long go(long A, long B){
        if(B==1){
            return A % C;
        }
        long ret = go(A,B/2);
        ret = (ret * ret) % C;
        if(B % 2 == 1) ret = (ret*A) %C;
        return ret;
    }
}