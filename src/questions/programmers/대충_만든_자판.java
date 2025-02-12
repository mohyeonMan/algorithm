package questions.programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
    keymap	targets	result
    ["ABACD", "BCEFD"]	["ABCD","AABB"]	[9, 4]
    ["AA"]	["B"]	[-1]
    ["AGZ", "BSSS"]	["ASA","BGZ"]	[4, 6]
 */
public class 대충_만든_자판 {
    private Map<Character,Integer> keyMinMap = new HashMap<>();
    private int keyMax = 100;

    public void solution(){
        String[] keymap = {"ABACD", "BCEFD"};
        String[] targets = {"ABCD","AABB"};

        for (String keys : keymap) {
            for (int i = 0; i < keys.length(); i++) {
                char key= keys.charAt(i);
                int currentMin = keyMinMap.getOrDefault(key, keyMax);
                keyMinMap.put(key, Math.min(currentMin, i + 1));
            }
        }

        int[] answer = new int[targets.length];
        for (int i = 0; i < targets.length; i++) {
            String string = targets[i];
            int sum = 0;
            for (int j = 0; j < string.length(); j++) {
                char key = string.charAt(j);
                if(!keyMinMap.containsKey(key)) {
                    sum = -1;
                    break;
                }
                sum += keyMinMap.get(key);
            }
            answer[i] = sum;
        }

        System.out.println(Arrays.toString(answer));
                
        
    }
    
}
