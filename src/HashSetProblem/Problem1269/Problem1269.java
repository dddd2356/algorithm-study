package HashSetProblem.Problem1269;

import java.util.HashSet;
import java.util.Scanner;

public class Problem1269 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        HashSet<Integer> setA = new HashSet<>();
        HashSet<Integer> setB = new HashSet<>();

        // A, B를 각각 HashSet에 저장
        for (int i = 0; i < A; i++) setA.add(sc.nextInt());
        for (int i = 0; i < B; i++) setB.add(sc.nextInt());

        int countA = 0;
        int countB = 0;

        // A에만 있는 것
        for (int num : setA) {
            if (!setB.contains(num)) countA++;
        }

        // B에만 있는 것
        for (int num : setB) {
            if (!setA.contains(num)) countB++;
        }

        System.out.println(countA + countB);
    }
}
