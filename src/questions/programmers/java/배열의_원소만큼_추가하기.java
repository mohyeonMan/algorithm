package questions.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 배열의_원소만큼_추가하기 {

    /*
     * arr result
     * [5, 1, 4] [5, 5, 5, 5, 5, 1, 4, 4, 4, 4]
     * [6, 6] [6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6]
     * [1] [1]
     */
    public void solution() {
        int[] arr = {5,1,4};

        List<Integer> answerList = new ArrayList<>();

        for(int i : arr){
            for (int j = i; j > 0; j--) {
                answerList.add(i);
            }
        }

        int[] answer = new int[answerList.size()];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        System.out.println(Arrays.toString(answer));
        
    }

}
