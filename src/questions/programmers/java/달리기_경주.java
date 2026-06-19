package questions.programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
    players	callings	result
    ["mumu", "soe", "poe", "kai", "mine"]	["kai", "kai", "mine", "mine"]	["mumu", "kai", "mine", "soe", "poe"]
 */
public class 달리기_경주 {
    private Map<String,Integer> currentRankMap;

    public void solution(){
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};
        
        init(players);

        for (String call : callings) {
            int currentRank = currentRankMap.get(call);
            String passed = players[currentRank - 1];
            
            players[currentRank] = passed;
            players[currentRank - 1] = call;

            currentRankMap.put(passed, currentRank);
            currentRankMap.put(call, currentRank - 1);
        }

        System.out.println(Arrays.toString(players));
    }

    private void init(String[] players){

        currentRankMap = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            String player = players[i];
            currentRankMap.put(player, i);
        }

    }
}