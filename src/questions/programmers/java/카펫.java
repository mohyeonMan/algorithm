package questions.programmers;

import java.util.Arrays;

/*
 * brown	yellow	return
10	2	[4, 3]
8	1	[3, 3]
24	24	[8, 6]
 */
public class 카펫 {

    
    public int[] solution(){
        int brown = 24;
        int yellow = 24;
    
        int widthHeightSumMax = brown / 2 + 2;
        
        for(int i = 3; i < widthHeightSumMax - 2 ; i ++){
            int width = widthHeightSumMax - i;
            int height = i;

            if((width - 2) * (height -2) == yellow){
                return new int[]{width, height};
            } 
        }
        
        return new int[]{-1,-1};
    }

}