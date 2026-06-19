package questions.programmers;

import java.util.Collections;
import java.util.HashMap;

public class 가장많이받은선물 {
    
    public int execute(){

        String[] friends = {"a", "b", "c", "d"};
        String[] gifts = {"a b", "b a"};

        HashMap<String, Integer> resultMap = new HashMap<>();
        for (String friends2 : friends) {
                resultMap.put(friends2, 0);
        }

        HashMap<String,FriendEntry> map = giftsToMap(gifts);

        for (int f = 0; f < friends.length ; f ++) {
            String givenFriend = friends[f];
            FriendEntry givenFriendEntry = map.getOrDefault(givenFriend,new FriendEntry());
            int givenFriendPPoint = givenFriendEntry.pPoint;

            for (int cf = f+1; cf < friends.length; cf ++){
                String compairFriend = friends[cf];
                FriendEntry compairFriendEntry = map.getOrDefault(compairFriend,new FriendEntry());
                int compairFriendPPoint = compairFriendEntry.pPoint;

                HashMap<String, Integer> givenFriendAmountMap = givenFriendEntry.gaveAmountMap;
                HashMap<String, Integer> compairFriendAmountMap = compairFriendEntry.gaveAmountMap;

                int givenFriendAmount = givenFriendAmountMap.getOrDefault(compairFriend,0);
                int compairFriendAmount = compairFriendAmountMap.getOrDefault(givenFriend, 0);

                if (
                    (givenFriendAmount == 0 && compairFriendAmount == 0) ||
                    givenFriendAmount == compairFriendAmount
                ) {
                    if(givenFriendPPoint < compairFriendPPoint){
                        resultMap.put(compairFriend, resultMap.get(compairFriend) + 1);
                    }else if(givenFriendPPoint > compairFriendPPoint){
                        resultMap.put(givenFriend , resultMap.get(givenFriend) + 1);
                    }

                }else if(givenFriendAmount > compairFriendAmount){
                    resultMap.put(givenFriend, resultMap.get(givenFriend) + 1);
                }else {
                    resultMap.put(compairFriend, resultMap.get(compairFriend) + 1);
                }
            }
        }


        return Collections.max(resultMap.values());
    }

    public HashMap<String,FriendEntry> giftsToMap(String[] gifts){

        HashMap<String,FriendEntry> processedMap = new HashMap<>();

        for (String gift : gifts) {
            String[] fromTo = gift.split(" ");
            insertIntoMap(processedMap, fromTo[0], fromTo[1]);
        }
        

        return processedMap;
    }

    public void insertIntoMap(HashMap<String,FriendEntry> entrys, String from, String to){
        FriendEntry givenFriendEntry = entrys.computeIfAbsent(from, k ->new FriendEntry());
        givenFriendEntry.pPoint++;
        FriendEntry takenFriendEntry = entrys.computeIfAbsent(to, k ->new FriendEntry());
        takenFriendEntry.pPoint--;

        givenFriendEntry.gaveAmountMap.merge(to, 1, Integer::sum);
    }

    
    public class FriendEntry{
        int pPoint = 0;
        HashMap<String,Integer> gaveAmountMap = new HashMap<>();
        
    }




}
