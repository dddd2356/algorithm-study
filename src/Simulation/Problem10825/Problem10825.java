package Simulation.Problem10825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem10825 {
    static class Student
    {
        String name;
        int kor;
        int eng;
        int math;
        Student(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Student[] students = new Student[N];
        for(int i=0; i<N; i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            students[i] = new Student(name, kor, eng, math);
        }

        Arrays.sort(students, (a,b)->{
            if (a.kor != b.kor)
                return b.kor - a.kor;
            if (a.eng != b.eng)
                return a.eng - b.eng;
            if (a.math != b.math)
                return b.math - a.math;
            return a.name.compareTo(b.name);
        });

        for(int i=0; i<students.length; i++){
            System.out.println(students[i].name);
        }
    }
}
