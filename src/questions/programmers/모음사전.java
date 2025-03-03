package questions.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * word	result
"AAAAE"	6
"AAAE"	10
"I"	1563
"EIO"	1189
 */
public class 모음사전 {

    String chars = "AEIOU";
    List<String> dict;

    public int solution(){

        String word = "AAAAE";

        dict = new ArrayList<>();
        
        bfs("");

        // Collections.sort(dict);

        for(int i = 0; i < dict.size(); i++){
            System.out.println(dict.get(i));
            if(dict.get(i).equals(word)) {
                System.out.println(i);
                return i;
            }
        }

        
        return -1;
    }

    private void bfs(String word){
        dict.add(word);
        if(word.length() == 5) return;

        for(int i=0; i < 5 ; i++){
            bfs(new String(word + chars.charAt(i)));
        }
    }

    
}