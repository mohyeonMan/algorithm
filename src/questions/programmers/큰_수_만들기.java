package questions.programmers;

import java.util.Stack;

/*
 * number	k	return
"1924"	2	"94"
"1231234"	3	"3234"
"4177252841"	4	"775841"
 */
public class 큰_수_만들기 {
    
    public void solution() {
        String number = "4177252841";
        int k = 4;

        Stack<Character> stack = new Stack<>();
        int len = number.length();
        int resultLen = len - k;

        for (char digit : number.toCharArray()) {
            while (!stack.isEmpty() && stack.peek() < digit && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }

        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < resultLen; i++) {
            sb.append(stack.get(i));
        }

        System.out.println(sb.toString());
    }
    
}
