package questions.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 * answers	return
[1,2,3,4,5]	[1]
[1,3,2,4,2]	[1,2,3]
 */
public class 모의고사 {
    
    public int[] solution(){

        int[] answers = {1,3,2,4,2};

        int length = answers.length;
        
        int[][] spj = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        int[] scores = new int[3];

        for(int i = 0; i<length; i++){
            for (int j = 0; j < spj.length; j++) {
                if(answers[i] == spj[j][i % spj[j].length]) scores[j]++;
            }
        }
        int maxScore = Arrays.stream(scores).max().getAsInt();

        List<Integer> winners = new ArrayList<>();
        for(int i = 0; i<length; i++){
            if(scores[i] == maxScore) winners.add(i + 1);
        }
        
        return winners.stream().mapToInt(a -> Integer.valueOf(a)).toArray();
        
        
        
    }
}
