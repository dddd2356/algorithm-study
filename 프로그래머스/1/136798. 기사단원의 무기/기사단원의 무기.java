class Solution {
    public int solution(int number, int limit, int power) {
    int[] divCount = new int[number + 1]; // 각 숫자의 약수 개수

    // i의 배수들에 약수 +1 (에라토스테네스 체 방식)
    for (int i = 1; i <= number; i++) {
        for (int j = i; j <= number; j += i) {
            divCount[j]++;
        }
    }

    int total = 0;
    for (int i = 1; i <= number; i++) {
        total += (divCount[i] > limit) ? power : divCount[i];
    }

    return total;
    }
}