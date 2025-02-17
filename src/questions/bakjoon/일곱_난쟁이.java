package questions.bakjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
    예제 입력
    20
    7
    23
    19
    10
    15
    25
    8
    13
 */
public class 일곱_난쟁이 {
    
    public void solution(){
        int[] minians = { 20, 7, 23, 19, 10, 15, 25, 8, 13 };

        List<Integer> miniansList = Arrays.stream(minians).boxed().sorted().collect(Collectors.toList());

        int total = Arrays.stream(minians).sum();
        int target = total - 100;
        
        boolean isFoundMonsters = false;
        for ( int i = miniansList.size() - 1; i > 0; i--) {
            int min1 = miniansList.get(i);
            if(min1 >= target) continue;
            for (int j = 0; j < i; j++) {
                int min2 = miniansList.get(j);
                if(min1 + min2 == target){
                    miniansList.remove(i); //뒤의 인덱스 먼저 지워줘야함
                    miniansList.remove(j);
                    isFoundMonsters = true;
                    break;
                }
            }

            if(isFoundMonsters) break;
        }

        int[] answer = miniansList.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(answer));

    }
    

}
