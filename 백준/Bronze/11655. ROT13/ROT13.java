import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char[] c= s.toCharArray();
        for(int i=0; i<s.length(); i++){
            if(c[i]>=65 && c[i]<91){
                if(c[i]+13 > 90)
                    c[i]= (char) (c[i]+13-26) ;
                else
                    c[i] = (char) (c[i]+13);
            }
            else if(c[i]>=97 && c[i]<123){
                if(c[i]+13>122){
                    c[i] = (char)(c[i]+13-26);
                }
                else {
                    c[i] = (char) (c[i]+13);
                }
            }
        }
        for(int i=0; i<s.length(); i++){
            System.out.print(c[i]);
        }
    }
}