package Simulation.Problem1244;

import java.util.Scanner;

public class Problem1244 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] switches = new int[n];
        for(int i=0; i<n; i++){
            switches[i] = sc.nextInt();
        }
        int person = sc.nextInt();
        sc.nextLine();
        for(int i=0; i<person; i++){
            int star = sc.nextInt();
            int location = sc.nextInt();
            sc.nextLine();
            if(star == 1) {
                for(int j=location-1; j<switches.length; j+=location) {
                    if (switches[j] == 1) {
                        switches[j] = 0;
                    }
                    else if (switches[j]==0){
                        switches[j] = 1;
                    }
                }
            }
            else if(star==2){
                switches[location - 1] ^= 1;  // 자신 토글
                int left = location - 2;
                int right = location;
                while (left >= 0 && right < n && switches[left] == switches[right]) {
                    switches[left] ^= 1;
                    switches[right] ^= 1;
                    left--;
                    right++;
                }
            }
        }
        // 출력: 20개씩 줄바꿈, 사이에 공백
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            if(i > 0 && i % 20 == 0) sb.append('\n');
            else if(i > 0) sb.append(' ');
            sb.append(switches[i]);
        }
        System.out.println(sb);
    }
}