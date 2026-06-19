package questions.programmers;

import java.util.Arrays;

/*
 * people	limit	return
[70, 50, 80, 50]	100	3
[70, 80, 50]	100	3
 */
public class 구명보트 {
    public void solution(){
        
        int[] people = {70,50,80,50};
        int limit = 100;

        Arrays.sort(people);

        System.out.println(Arrays.toString(people));
        int start = 0;
        int end = people.length-1;
        int answer = 0;
        
        while(start < end){
            if(people[start] + people[end] <= limit){
                start++;
                end--;
                answer++;
            }else{
                end--;
                answer++;
            }
        }

        if(start == end){
            answer++;
        }

        System.out.println(answer);

    }
}
