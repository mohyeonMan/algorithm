package questions.programmers;

import java.util.HashMap;

public class 둘만의암호 {
    
    public void execute(){


        String s = "aukks";
        String skip = "wbqd";

        int index = 5;

        char[] sArr = s.toCharArray();
        char[] skipArr = skip.toCharArray();
        String answer = "";
        
        HashMap<Character,Boolean> skipMap = new HashMap<>();

        for(char al : skipArr){
            skipMap.put(al, true);
        }

        for(char al :sArr){
            int skipCount = index;

            while (skipCount > 0) {
                skipCount--;
                al ++;
                if(al > 'z'){
                    al -= 26;
                }
                if(skipMap.get(al)!= null){
                    skipCount++;
                }
            }
            answer += al;
        }

       System.out.println(answer);


    }

}
