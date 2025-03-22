package questions.programmers;

import java.util.Arrays;

/*
 * routes	return
[[-20,-15}, {-14,-5}, {-18,-13}, {-5,-3]]	2
 */
public class 단속카메라 {

    public void solution(){

        int[][] routes = {{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}};

        Arrays.sort(routes,
            (r1, r2) -> {
                if(r1[0] == r2[0]) return Integer.compare(r2[1], r1[1]);
                return Integer.compare(r1[0], r2[0]);
            }
        );

        int answer = 1;

        int start;
        int end = Integer.MAX_VALUE;
        for(int[] route : routes){
            start = route[0];
            end = Math.min(end, route[1]);
            if(start > end){
                answer ++;
                end = route[1];
            }
        }

        System.out.println(answer);

    }
    
}
