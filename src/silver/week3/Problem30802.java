package silver.week3;

import java.util.Scanner;

public class Problem30802 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] applicant = new int[6];
        for(int i=0; i<applicant.length;i++){
            applicant[i]=sc.nextInt();
        }
        int T = sc.nextInt();
        int P = sc.nextInt();
        int tCount = 0;
        for(int i=0;i<applicant.length; i++){
            if(applicant[i]/T == 0 && applicant[i] % T == 0){
                tCount = tCount + 0;
            }
            else if(applicant[i]/T !=0 && applicant[i] % T ==0){
                tCount = tCount + (applicant[i]/T);
            }
            else
                tCount = tCount + (applicant[i]/T) + 1;
        }
        System.out.println(tCount);
        System.out.println(N/P + " " + N%P);
    }
}
