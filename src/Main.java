import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dx={0,0,1,-1};
        int[] dy={1,-1,0,0};
        int[][] space = new int[100][100];
        int result =0;
        for(int i=0; i<N; i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for(int j=x; j<x+10;j++){
                for(int z=y; z<y+10;z++) {
                    space[j][z] = 1;
                }
            }
        }
        for(int j=0; j<100;j++){
            for(int z=0; z<100;z++) {
                if (space[j][z] == 1) {
                    for (int k = 0; k < 4; k++) {
                        int ni = j + dx[k];
                        int nj = z + dy[k];

                        // 범위를 벗어나면 바깥(0)으로 간주해서 테두리 1개 추가
                        if (ni < 0 || ni >= 100 || nj < 0 || nj >= 100 || space[ni][nj] == 0) {
                            result++;
                        }
                    }
                }
            }
        }
        System.out.println(result);
    }
}
