package questions.programmers;

import java.util.ArrayDeque;
import java.util.Arrays;

/*
 * arr	answer
    [1,1,3,3,0,1,1]	[1,3,0,1]
    [4,4,4,3,3]	[4,3]
 */
public class 같은_숫자는_싫어 {

    public void solution(){
        int[] arr = {1,1,3,3,0,1,1};

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for(int i : arr){
            if(!stack.isEmpty() && stack.peekLast() == i) continue;
            stack.addLast(i);
        }

        int[] answer = new int[stack.size()];

        for(int i = 0; i < answer.length; i++){
            answer[i] = stack.poll();
        }

        System.out.println(Arrays.toString(answer));
        

    }
}
