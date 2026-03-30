import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        boolean isTrue = true;
        char[] c = new char[s.length()];
        c = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (c[i] != c[s.length() - i - 1]) {
                isTrue = false;
                break;
            }
        }
        if (isTrue) {
            System.out.println(1);
        }
        else if(isTrue == false){
            System.out.println(0);
        }
    }
}