package questions.programmers;

import java.util.Arrays;

/*
    A	B	answer
    [1, 4, 2]	[5, 4, 4]	29
    [1,2]	[3,4]	10
 */ 
public class 최솟값_만들기 {
    
    public void solution(){
        int[] A = {1,4,2};
        int[] B = {5,4,4};
        
        int answer = 0;
        int length = A.length;

        Arrays.sort(A);
        Arrays.sort(B);
        for(int i = 0; i< length; i++){
            answer += A[i] *  B[length -1 - i]; 
        }
        System.out.println(answer); 
    }
}
