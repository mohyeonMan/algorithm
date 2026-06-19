package questions.programmers;

import java.util.Arrays;
import java.util.Comparator;

/*
 * s	return
"1 2 3 4"	"1 4"
"-1 -2 -3 -4"	"-4 -1"
"-1 -1"	"-1 -1"
 */
public class 최댓값과_최솟값 {

    
    public void solution(){
        String s = "-1 -2 -3 -4";
        String[] split = s.split(" ");
        Arrays.sort(split, Comparator.comparingInt(Integer::valueOf));
        
        System.out.println(split[0] + " " + split[split.length-1]);
        
    }
    
}