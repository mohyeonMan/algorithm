package questions.programmers;

import java.util.Arrays;
import java.util.Stack;

/*
 * prices	return
[1, 2, 3, 2, 3]	[4, 3, 1, 1, 0]
 */
public class 주식가격 {
    
    public void solution(){

        int[] prices = {1, 2, 3, 2, 3};
        int length = prices.length;
        
        int[] answer = new int[length];

        Stack<Integer> stack = new Stack<>();

        for(int i= 0; i<length; i++){
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int n = stack.pop();
                answer[n] = i-n;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int n = stack.pop();
            answer[n] = length - n - 1;
        }

        System.out.println(Arrays.toString(answer));


    }
}
