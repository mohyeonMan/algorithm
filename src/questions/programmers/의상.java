package questions.programmers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * clothes	return
    [["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]]	5
    [["crow_mask", "face"], ["blue_sunglasses", "face"], ["smoky_makeup", "face"]]	3
 */
public class 의상 {
    Map<String,Set<String>> clothesMap;

    public void solution(){
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        
        clothesMap = new HashMap<>();
        
        for(String[] cloth : clothes){
            String category = cloth[1];
            String name = cloth[0];
            Set<String> nameSet = clothesMap.computeIfAbsent(category, k -> new HashSet<>());
            nameSet.add(name);
        }
        
        int answer = 1;
        
        for(Set<String> set : clothesMap.values()){
            answer *= set.size() + 1 ;
        }

        System.out.println(answer - 1);

    }
}
