package questions.programmers;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
 * numbers	return
    [6, 10, 2]	"6210"
    [3, 30, 34, 5, 9]	"9534330"
 */
public class 가장_큰_수 {

    public void solution() {
        int[] numbers = {3, 30, 34, 5, 9};

        String answer = Arrays.stream(numbers)
            .mapToObj(String::valueOf)
            .sorted((a, b) -> (b + a).compareTo(a + b))
            .collect(Collectors.joining(""));
        
        System.out.println( answer.startsWith("0")? "0" : answer );

    }
    
    
}
