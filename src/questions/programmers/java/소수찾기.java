package questions.programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * numbers	return
"17"	3
"011"	2
 */
public class 소수찾기 {
    Map<String,Boolean> answerMap;
    String[] numbersArr;
    boolean[] visited;
    

    public int solution(){
        String numbers = "17";

        numbersArr = numbers.split("");
        visited = new boolean[numbersArr.length];
        answerMap = new HashMap<>();

        for(int i = 0; i < numbersArr.length; i++){
            if(numbersArr[i].equals("0")) continue;
            visited[i] = true;
            recursive(numbersArr[i]);
            visited[i] = false;
        }

        return answerMap.size();

    }

    private void recursive(String num){

        if(!answerMap.containsKey(num) && isPrime(Integer.valueOf(num))){
            answerMap.put(num, false);
        }

        for(int i = 0; i< numbersArr.length; i++){
            if(!visited[i]){
                visited[i] = true;
                recursive(num + numbersArr[i]);
                visited[i] = false;
            }
        }
        
        
    }

    private boolean isPrime(int num){
        if(num == 1) return false;

        int count = 0;
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if(num % i == 0){
                count+=2;
            }
        }

        return count == 2;
    }
}
