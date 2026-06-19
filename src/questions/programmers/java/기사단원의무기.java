package questions.programmers;

import java.util.HashSet;
import java.util.Set;

/*
    number	limit	power	result
    5	3	2	10
    10	3	2	21
 */
public class 기사단원의무기 {
    
    public void solution(){

        int number = 5;
        int limit = 3;
        int power = 2;

        int answer = 0;
        
        for (int start = 1; start <= number; start++) {
            Set<Integer> set = new HashSet<>();
            int currentAnswer = 1;
            for (int current = 1; current <= Math.sqrt(start); current++) {
                
                if(start % current == 0){
                    set.add(current);
                    set.add(start / current);
                    currentAnswer = set.size();
                }
                
                if(set.size() > limit){
                    currentAnswer = power;
                    break;
                }
            }
            answer += currentAnswer;
        }

        System.out.println(answer);

    }

}
