package questions.programmers;

import java.util.HashMap;
import java.util.Map;

/*
 *  nums	result
    [3,1,2,3]	2
    [3,3,3,2,2,4]	3
    [3,3,3,2,2,2]	2
 */
public class 폰켓몬 {
    Map<Integer,Integer> pokemonMap;

    public void solution(){
        int[] nums = {3,1,2,3};
        int half = nums.length / 2;
        
        pokemonMap = new HashMap<>();
        
        for(int num : nums){
            pokemonMap.put(num,pokemonMap.getOrDefault(num, 0) + 1);
        }
        
        System.out.println(Math.min(half, pokemonMap.size()));
    }
}
