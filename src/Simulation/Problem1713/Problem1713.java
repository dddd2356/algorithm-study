package Simulation.Problem1713;

import java.util.*;

public class Problem1713 {
    static class Candidate {
        int id;
        int count;
        int time; // 들어온 시점(작을수록 오래됨)
        Candidate(int id, int count, int time) {
            this.id = id;
            this.count = count;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();      // 사진틀 개수
        int total = sc.nextInt();  // 추천 수 (총 횟수)
        List<Candidate> frames = new ArrayList<>();
        int currentTime = 0;

        for (int i = 0; i < total; i++) {
            int student = sc.nextInt();

            // 이미 프레임에 있으면 추천수 증가
            boolean found = false;
            for (Candidate c : frames) {
                if (c.id == student) {
                    c.count++;
                    found = true;
                    break;
                }
            }
            if (found) continue;

            // 프레임에 없고 빈 슬롯이 있으면 추가
            if (frames.size() < N) {
                frames.add(new Candidate(student, 1, currentTime++));
            } else {
                // 프레임이 가득 찼으면 제거할 후보를 찾음
                // 1) 추천수 최소, 2) 추천수 같으면 time이 가장 작은(=오래된) 것 제거
                int idxToRemove = 0;
                for (int j = 1; j < frames.size(); j++) {
                    Candidate a = frames.get(idxToRemove);
                    Candidate b = frames.get(j);
                    if (b.count < a.count) {
                        idxToRemove = j;
                    } else if (b.count == a.count) {
                        if (b.time < a.time) idxToRemove = j;
                    }
                }
                frames.remove(idxToRemove);
                frames.add(new Candidate(student, 1, currentTime++));
            }
        }

        // 결과: 프레임에 남아있는 학생 번호를 오름차순 출력
        ArrayList<Integer> res = new ArrayList<>();
        for (Candidate c : frames) res.add(c.id);
        Collections.sort(res);
        for (int id : res) System.out.print(id + " ");
        sc.close();
    }
}