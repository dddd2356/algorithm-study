import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String s) {
        char[] words = new char[s.length()];
        words = s.toCharArray();

        ArrayList<Integer> list = new ArrayList<>();
        //숫자, 인덱스 위치
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0; i<words.length; i++){
            if(map.containsKey(words[i])){
                list.add(i-map.get(words[i]));
                map.put(words[i], i);
            }
            else{
                map.put(words[i],i);
                list.add(-1);
            }
        }
        int[] result = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            result[i]=list.get(i);
        }
        return result;
    }
}