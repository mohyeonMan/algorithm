package questions.programmers;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * 
 * priorities	location	return
[2, 1, 3, 2]	2	1
[1, 1, 9, 1, 1, 1]	0	5
 */
public class 프로세스 {
    
    class Process{
       int index;
       int priority;

        Process(int index, int priority){
                    this.index = index;
                    this.priority = priority;
        }
    }
    
    public void solution(){
        int[] priorities = {2, 1, 3, 2};
        int location = 2;

        Queue<Process> processQueue = new ArrayDeque<>();
        
        for(int i = 0; i<priorities.length; i++){
            processQueue.add(new Process(i, priorities[i]));
        }

        Arrays.sort(priorities);

        while(!processQueue.isEmpty()){
            if(processQueue.peek().priority >= priorities[processQueue.size()-1]) {
                Process process = processQueue.poll();
                if(process.index == location) {
                    System.out.println((priorities.length - processQueue.size()));
                    break;
                }
            }else{
                processQueue.add(processQueue.poll());
            }

        }
        
        
    }


}
