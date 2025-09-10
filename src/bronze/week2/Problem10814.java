package bronze.week2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Problem10814 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Member[] member = new Member[N];
        for(int i=0;i<N;i++){
            member[i] = new Member(sc.nextInt(),sc.nextLine());
        }
        // 타입을 Member 으로 둘 것.
        Arrays.sort(member, new Comparator<Member>() {
            // 나이순으로 정렬
            @Override
            public int compare(Member s1, Member s2) {
                return s1.age - s2.age;
            }
        });
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            // 객체배열의 객체를 출력하면 해당 인덱스의 객체의 toString() 이 출력 됨
            sb.append(member[i]);
        }

        System.out.println(sb);

    }

    public static class Member{
        int age;
        String name;
        public Member(int age, String name){
            this.age= age;
            this.name = name;
        }
        @Override
        public String toString() {
            return age + name + "\n";
        }
    }
}
