package questions.programmers;

import java.util.LinkedList;
import java.util.Queue;

/*
    bridge_length	weight	truck_weights	return
    2	10	[7,4,5,6]	8
    100	100	[10]	101
    100	100	[10,10,10,10,10,10,10,10,10,10]	110
*/
public class 다리를_지나는_트럭 {
    
    public void solution(){
        int bridge_length = 100;
        int weight = 100;
        int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};


        Queue<Integer> bridge = new LinkedList<>();
        int nextIndex = 0;
        int currentTime = 0;
        int currentWeight = 0;

        for(int i = 0; i< bridge_length; i++){
            bridge.add(0);
        }

        boolean isValidIndex = true;
        while(!bridge.isEmpty()){
            currentWeight -= bridge.poll();
            currentTime ++;

            if(isValidIndex){
                int nextWeight = truck_weights[nextIndex];
                if(weight >= currentWeight + nextWeight){ // 다음 투입하는 경우.
                    bridge.add(nextWeight);
                    currentWeight += nextWeight;
                    if(truck_weights.length -1 < nextIndex + 1) isValidIndex = false; // 유효성검증
                    else nextIndex++;
                }else{
                    bridge.add(0);
                }
            }
            
        }
        System.out.println(currentTime);
    }

}