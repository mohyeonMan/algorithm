package questions.programmers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
    lottos	win_nums	result
    [44, 1, 0, 0, 31, 25]	[31, 10, 45, 1, 6, 19]	[3, 5]
    [0, 0, 0, 0, 0, 0]	[38, 19, 20, 40, 15, 25]	[1, 6]
    [45, 4, 35, 20, 3, 9]	[20, 9, 3, 45, 4, 35]	[1, 1]
 */
public class 로또의_최고_순위와_최저_순위 {

    public void solution(){
        final int[] lottos = {45, 4, 35, 20, 3, 9};
        final int[] win_nums = {20, 9, 3, 45, 4, 35};

        List<Integer> winNumsList = Arrays.stream(win_nums).boxed().collect(Collectors.toList());

        int zeroCount = 0;
        int correctCount = 0;
        for (int num : lottos) {
            if(num == 0) zeroCount++;
            if(winNumsList.contains(num)) correctCount++;
        }

        int[] answer = new int[]{getPrice(correctCount + zeroCount), getPrice(correctCount)};

        System.out.println(Arrays.toString(answer));
    }
    
    private int getPrice(final int correctCount){
        return Math.min(7 - correctCount, 6);
    }
}