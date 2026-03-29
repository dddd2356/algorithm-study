import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        String dopa = "abcde";
        double sum=0;
        String dopa2 = dopa.substring(0,3);
        sb.append(dopa2);
        System.out.println(dopa2);
        System.out.println(sb.reverse());
        System.out.println(sb+"umzunsik");
        String avg = String.format("%.2f",sum);
        System.out.println(avg);
    }
}