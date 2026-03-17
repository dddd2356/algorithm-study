package Simulation.Problem1475;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Problem1475 {
    public static void main(String[] args) throws IOException {
        HashMap<Integer, Integer> map = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] num  = new int[s.length()];
        for(int i=0; i<num.length; i++){
            num[i]= s.charAt(i)-'0';
            map.put(num[i], map.getOrDefault(num[i],0)+1);
        }
        int max = 0;

        int six = map.getOrDefault(6, 0);
        int nine = map.getOrDefault(9, 0);

        int sixNine = (six + nine + 1) / 2;

        map.remove(6);
        map.remove(9);

        map.put(15, sixNine); // 임시 key

        ArrayList<Integer> result = new ArrayList<>();
        result.addAll(map.keySet());

        for(int i=0; i<result.size(); i++){

            if(max<map.get(result.get(i))){
                max = map.get(result.get(i));
            }
        }
        System.out.println(max);
    }
}
