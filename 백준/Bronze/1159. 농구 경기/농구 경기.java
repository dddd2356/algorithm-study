import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] cnt = new int[26];
        for(int i=0; i<num; i++){
            String human = br.readLine();
            cnt[human.charAt(0)-'a']++;

        }
        boolean isCollect = false;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<cnt.length; i++){
            if(cnt[i]>=5){
                sb.append((char) ('a' + i));
                isCollect=true;
            }
        }
        if(isCollect) {
            System.out.println(sb);
        }
        else
            System.out.println("PREDAJA");
    }
}