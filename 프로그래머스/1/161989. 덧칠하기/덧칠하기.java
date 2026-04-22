import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        boolean[] isTrue = new boolean[n + 1];
        Arrays.fill(isTrue, true);

        for(int i=0; i<section.length; i++) {
            isTrue[section[i]] = false;
        }

        int result = 0;
        int i = 1;

        while (i <= n) {
            if (!isTrue[i]) {
                result++;
                i += m;
            } else {
                i++;
            }
        }

        return result;
    }
}