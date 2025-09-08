package bronze.week2;

import java.util.Objects;
import java.util.Scanner;

public class Problem28702 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] a = new String[3];
        for (int i = 0; i < 3; i++) {
            a[i] = sc.next();
        }
        int num=0;
        if(!Objects.equals(a[0], "Fizz") && !Objects.equals(a[0], "Buzz") && !Objects.equals(a[0], "FizzBuzz")) {
            num = Integer.parseInt(a[0]);
            if((num+3)%3==0 && (num+3)%5==0){
                System.out.println("FizzBuzz");
            }
            else if((num+3)%3==0 && (num+3)%5!=0){
                System.out.println("Fizz");
            }
            else if((num+3)%3!=0 && (num+3)%5==0){
                System.out.println("Buzz");
            }
            else
                System.out.println(num+3);
        }
        else if(!Objects.equals(a[1], "Fizz") && !Objects.equals(a[1], "Buzz") && !Objects.equals(a[1], "FizzBuzz")) {
            num = Integer.parseInt(a[1]);
            if ((num + 2) % 3 == 0 && (num + 2) % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if ((num + 2) % 3 == 0 && (num + 2) % 5 != 0) {
                System.out.println("Fizz");
            } else if ((num + 2) % 3 != 0 && (num + 2) % 5 == 0) {
                System.out.println("Buzz");
            } else
                System.out.println(num + 2);
        }

        else if(!Objects.equals(a[2], "Fizz") && !Objects.equals(a[2], "Buzz") && !Objects.equals(a[2], "FizzBuzz")) {
            num = Integer.parseInt(a[2]);
            if((num+1)%3==0 && (num+1)%5==0){
                System.out.println("FizzBuzz");
            }
            else if((num+1)%3==0 && (num+1)%5!=0){
                System.out.println("Fizz");
            }
            else if((num+1)%3!=0 && (num+1)%5==0){
                System.out.println("Buzz");
            }
            else
                System.out.println(num+1);
        }
    }
}
