package Simulation.Problem20006;

import java.io.*;
import java.util.*;

public class Problem20006 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < p; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(str.nextToken());
            String name = str.nextToken();

            map.put(name, level);
            result.add(name);
        }

        // 방 목록
        ArrayList<HashMap<String, Integer>> rooms = new ArrayList<>();

        // 방장 레벨 따로 저장
        ArrayList<Integer> leaderLevel = new ArrayList<>();

        for (int i = 0; i < result.size(); i++) {

            String name = result.get(i);
            int level = map.get(name);

            boolean added = false;

            for (int r = 0; r < rooms.size(); r++) {

                HashMap<String, Integer> room = rooms.get(r);

                if (room.size() >= m) continue;

                int leader = leaderLevel.get(r);

                if (Math.abs(leader - level) <= 10) {
                    room.put(name, level);
                    added = true;
                    break;
                }
            }

            // 방 못 찾으면 새 방 생성
            if (!added) {

                HashMap<String, Integer> newRoom = new HashMap<>();
                newRoom.put(name, level);

                rooms.add(newRoom);
                leaderLevel.add(level);   // 방장 저장
            }
        }

        StringBuilder sb = new StringBuilder();

        for (HashMap<String, Integer> room : rooms) {

            if (room.size() == m) sb.append("Started!\n");
            else sb.append("Waiting!\n");

            // 정렬 (필수)
            ArrayList<String> names = new ArrayList<>(room.keySet());
            Collections.sort(names);

            for (String name : names) {
                sb.append(room.get(name))
                        .append(" ")
                        .append(name)
                        .append("\n");
            }
        }

        System.out.print(sb);
    }
}