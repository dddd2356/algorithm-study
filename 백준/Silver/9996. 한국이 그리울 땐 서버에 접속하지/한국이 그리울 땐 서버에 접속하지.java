import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String s = br.readLine();
        char[] c = s.toCharArray();
        int pos=0;
        for(int i =0; i<s.length(); i++){
            if(c[i]=='*'){
                pos=i;
            }
        }
        String prefix = s.substring(0,pos);
        String suffix = s.substring(pos+1);

        for(int i=0; i<num; i++) {
            String answer = br.readLine();
            if (prefix.length() + suffix.length() > answer.length()) {
                System.out.println("NE");
            } else {
                if (prefix.equals(answer.substring(0, prefix.length())) && suffix.equals(answer.substring(answer.length() - suffix.length()))) {
                    System.out.println("DA");
                } else
                    System.out.println("NE");
            }
        }
    }
}