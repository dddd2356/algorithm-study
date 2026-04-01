import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line=br.readLine()) != null) {
            long n = Long.parseLong(line);
            long cnt =1;
            int ret = 1;
            while (true) {
                if(cnt%n==0){
                    System.out.println(ret);
                    break;
                }
                else{
                    cnt = (cnt *10) +1;
                    cnt %=n;
                    ret++;
                }
            }
        }
    }
}