package questions.programmers;

import java.util.Arrays;

/*
 * n	lost	reserve	return
5	[2, 4]	[1, 3, 5]	5
5	[2, 4]	[3]	4
3	[3]	[1]	2
 */
public class 체육복 {
    boolean[] isReserve;
    boolean[] isLost;

    public void solution(){

        int n = 5;
        int[] lost = {2,4};
        int[] reserve = {1,3,5};

        Arrays.sort(lost);

        int answer = n - lost.length;

        isReserve = new boolean[n + 2];
        isLost = new boolean[n + 2];

        for(int r : reserve){
            isReserve[r] = true;
        }
        for(int l : lost){
            isLost[l] = true;
        }

        for(int l : lost){

            if(isReserve[l]){
                answer ++;
                isReserve[l] = false;
                continue;
            }

            if(isReserve[l -1]){
                answer ++;
                isReserve[l -1] = false;
                continue;
            }

            if(isReserve[l + 1] && !isLost[l + 1]){
                answer ++;
                isReserve[l + 1] = false;
                continue;
            }
        }


        System.out.println(answer);


    }
    
}
