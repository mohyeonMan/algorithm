package questions.programmers;

import java.util.Stack;

/*
 * s	answer
    "()()"	true
    "(())()"	true
    ")()("	false
    "(()("	false
 */
public class 올바른_괄호 {

    public boolean solution(){
        String s = "(())()";

        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < s.length(); i ++){

            char a = s.charAt(i);
            if(a == '(') stack.push(a);
            else if(stack.isEmpty()) return false;
            else stack.pop();
        }

        if(!stack.isEmpty()) return false;

        return true;

    }
    
}
