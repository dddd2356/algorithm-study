import java.util.HashMap;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        HashMap<Character, Integer> minPress = new HashMap<>();

        for (String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                char ch = key.charAt(i);
                int pressCount = i + 1; 

                if (!minPress.containsKey(ch) || pressCount < minPress.get(ch)) {
                    minPress.put(ch, pressCount);
                }
            }
        }

        int[] answer = new int[targets.length];

        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            int totalPress = 0;
            boolean isPossible = true;

            for (int j = 0; j < target.length(); j++) {
                char ch = target.charAt(j);

                if (minPress.containsKey(ch)) {
                    totalPress += minPress.get(ch);
                } else {
                    isPossible = false;
                    break;
                }
            }

            answer[i] = isPossible ? totalPress : -1;
        }

        return answer;
    }
}