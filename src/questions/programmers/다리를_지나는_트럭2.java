package questions.programmers;

import java.util.Map;
import java.util.HashMap;

/*
    bridge_length	weight	truck_weights	return
    2	10	[7,4,5,6]	8
    100	100	[10]	101
    100	100	[10,10,10,10,10,10,10,10,10,10]	110
*/
public class 다리를_지나는_트럭2 {
    Map<Integer,Integer> truckMap;

    public void solution(){
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};

        truckMap = new HashMap<>();

        int currentTime = 0;
        int currentIndex = 0;
        int currentWeight = 0;
        boolean noTrucksLeft = false;

        while(!noTrucksLeft || !truckMap.isEmpty()){
            currentTime++;
            currentWeight -= truckMap.getOrDefault(currentTime, 0);
            truckMap.remove(currentTime);

            if(!noTrucksLeft){
                int currentTruck = truck_weights[currentIndex];
                if(weight >= currentWeight + currentTruck){
                    truckMap.put(currentTime + bridge_length, currentTruck);
                    currentWeight += currentTruck;

                    if(currentIndex + 1 > truck_weights.length - 1) noTrucksLeft = true;
                    else currentIndex ++;
                }
            }

        }
        
        System.out.println(currentTime);
        


    }
    
}