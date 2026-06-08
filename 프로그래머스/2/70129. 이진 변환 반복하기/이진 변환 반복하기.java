class Solution {
    public int[] solution(String s) {
        int transformCount = 0;
        int zeroCount = 0;

        while (!s.equals("1")) {
            int originalLength = s.length();
        
            s = s.replaceAll("0", "");
            int newLength = s.length();
            
            zeroCount += (originalLength - newLength);
            
            s = Integer.toBinaryString(newLength);
            transformCount++;
        }

        return new int[]{transformCount, zeroCount};
    }
}