package questions.programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * jobs	return
[[0, 3], [1, 9], [3, 5]]	8
 */
public class 디스크_컨트롤러 {

    public void solution(){

        int[][] jobs = {{0, 3}, {1, 9}, {3, 5}};
        // int[][] jobs = {{0,100},{10,10}};
        
        Queue<int[]> fastPriority = new PriorityQueue<>(Comparator.comparingInt(j -> j[0]));
        Queue<int[]> shortPriority = new PriorityQueue<>(Comparator.comparingInt(j -> j[1]));
            
        for (int[] job : jobs) {
            fastPriority.add(job);
        }

        int totalTime = 0;
        int currentTime = fastPriority.peek()[0];

        while(!fastPriority.isEmpty() || !shortPriority.isEmpty()){
            while(!fastPriority.isEmpty() && currentTime >= fastPriority.peek()[0]){
                shortPriority.add(fastPriority.poll());
            } 

            if(!shortPriority.isEmpty()){
                int[] cur = shortPriority.poll();
                currentTime += cur[1];
                totalTime += currentTime - cur[0];
            }else{
                currentTime = fastPriority.peek()[0];
            }

        }

        System.out.println(totalTime / jobs.length);

    }
}
