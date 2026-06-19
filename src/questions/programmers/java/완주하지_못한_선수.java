package questions.programmers;

import java.util.HashMap;
import java.util.Map;

/*
 * participant	completion	return
    ["leo", "kiki", "eden"]	["eden", "kiki"]	"leo"
    ["marina", "josipa", "nikola", "vinko", "filipa"]	["josipa", "filipa", "marina", "nikola"]	"vinko"
    ["mislav", "stanko", "mislav", "ana"]	["stanko", "ana", "mislav"]	"mislav
 */
public class 완주하지_못한_선수 {
    Map<String,Integer> completionMap; 
    
    public String solution() {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        
        completionMap = new HashMap<>();
        
        for(String runner : completion){
            completionMap.put(runner,completionMap.getOrDefault(runner, 0) + 1);
        }
        
        
        String answer = "";
        for(String runner : participant){
            if(!completionMap.containsKey(runner)){
                answer = runner;
                break;
            }
            
            int current = completionMap.get(runner) - 1;
            if(current == 0){
                completionMap.remove(runner);
            }else{
                completionMap.put(runner, current);    
            }
            
        }
        
        return answer;
    }
}
