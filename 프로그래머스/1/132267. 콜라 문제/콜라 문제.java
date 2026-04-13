class Solution {
    public int solution(int a, int b, int n) {
        int cnt = 0;
        int total = 0;
        while (n >= a) {
            cnt = n / a;
            total+=cnt*b;
            n = n - (a * cnt) + (b * cnt);
        }
        return total;
    }
}