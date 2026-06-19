package questions.programmers;

import java.util.PriorityQueue;
import java.util.Queue;

/*
 * scoville	K	return
[1, 2, 3, 9, 10, 12]	7	2
 */
public class 더_맵게 {
    
    public void solution(){
        
        int[] scoville = {1, 2, 3, 9, 13, 12};
        int K = 7;
    
        int answer =0;
    
        Queue<Integer> queue = new PriorityQueue<>();
        for(int s : scoville){
            queue.add(s);
        }

        while(queue.peek() < K){
            if(queue.size() < 2){
                answer = -1;
                break;    
            }
            int cur = queue.poll();
            int nxt = queue.poll();
            answer ++;

            queue.add(cur + (nxt * 2));
        }

        System.out.println(answer);
        
    }

}
