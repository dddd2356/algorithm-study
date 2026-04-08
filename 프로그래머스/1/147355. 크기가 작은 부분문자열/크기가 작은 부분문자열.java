class Solution {
    public int solution(String t, String p) {
        int cnt = 0;
        int len = p.length();

        for(int i = 0; i <= t.length() - len; i++){
            String sub = t.substring(i, i + len);

            if(Long.parseLong(sub) <= Long.parseLong(p)){
                cnt++;
            }
        }
        return cnt;
    }
}