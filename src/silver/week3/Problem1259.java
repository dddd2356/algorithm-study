package silver.week3;

import java.io.IOException;
import java.util.Scanner;

public class Problem1259 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while(true){
            String n = sc.nextLine();
            if(n.equals("0"))
                break;
            if(n.length()==1) {
                System.out.println("yes");
            }
            else{
                for(int j=0;j<n.length();j++){
                    if(n.charAt(j)!=n.charAt(n.length()-1-j)){
                        System.out.println("no");
                        break;
                    }
                    else if(j==n.length()/2-1){
                        System.out.println("yes");
                        break;
                    }
                }
            }
        }
    }
}