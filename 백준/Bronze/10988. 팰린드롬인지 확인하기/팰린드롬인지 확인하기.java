import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String reversed = new StringBuilder(s).reverse().toString();
        if(s.equals(reversed)){
            System.out.println(1);
        }
        else{
            System.out.println(0);
        }
    }
}