package questions.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
 * progresses	speeds	return
[93, 30, 55]	[1, 30, 5]	[2, 1]
[95, 90, 99, 99, 80, 99]	[1, 1, 1, 1, 1, 1]	[1, 3, 2]
 */
public class 기능개발 {
    
    
    public void solution(){
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        Stack<Integer> stack = new Stack<>();

        for(int i = progresses.length -1; i >= 0  ; i --){
            int time = (int)Math.ceil((100.0 - progresses[i]) / speeds[i]) ;
            stack.push(time);
        }
        
        List<Integer> deploys = new ArrayList<>();
        int before = stack.pop();
        int count = 1;

        while(!stack.isEmpty()){
            
            if(stack.peek() > before){
                deploys.add(count);
                before = stack.pop();
                count = 1;
                continue;
            }

            stack.pop();
            count ++;
        }

        deploys.add(count);

        System.out.println(Arrays.toString(deploys.stream().mapToInt(a -> Integer.valueOf(a)).toArray()));
        
    }
}
