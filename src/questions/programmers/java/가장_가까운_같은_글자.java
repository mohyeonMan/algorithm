package questions.programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
    s	result
    "banana"	[-1, -1, -1, 2, 2, 2]
    "foobar"	[-1, -1, 1, -1, -1, -1]
 */
public class 가장_가까운_같은_글자 {
    private Map<Character,Integer> wordMap;

    public void solution(){
        String s = "banana";

        wordMap = new HashMap<>();
        int[] answer = new int[s.length()];
        
        for(int i = 0 ; i < s.length(); i ++){
            char word = s.charAt(i);
            if(!wordMap.containsKey(word)) {
                answer[i] = -1;
            }else{
                answer[i] = i - wordMap.get(word);
            }
            wordMap.put(word, i);
        }

        System.out.println(Arrays.toString(answer));
    }
    
}
