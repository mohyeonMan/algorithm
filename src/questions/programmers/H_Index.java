package questions.programmers;

import java.util.Arrays;

/*
 * citations	return
    [3, 0, 6, 1, 5]	3
 */
public class H_Index {
    
    public void solution(){

        int[] citations = {3, 0, 6, 1, 5};
        Arrays.sort(citations);

        int len = citations.length;

        for(int i = 0; i<len ; i++){
            if(citations[i] >= len - i){
                System.out.println(len - i);
                break;
            }
        }

    }
    

}
