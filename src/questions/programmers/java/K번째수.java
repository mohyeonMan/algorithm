package questions.programmers;

import java.util.Arrays;

/*
 * array	commands	return
    [1, 5, 2, 6, 3, 7, 4]	{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}}	[5, 6, 3]
 */
public class K번째수 {

    public void solution(){
        
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        int[] answer = new int[commands.length];

        for(int i = 0; i< commands.length; i++){
            int[] command = commands[i];
            int from = command[0] -1;
            int to = command[1] -1;
            int index = command[2] -1;

            int[] copy = Arrays.copyOfRange(array,from,to+1);
            Arrays.sort(copy);
            answer[i] = copy[index];
        }

        System.out.println(Arrays.toString(answer));
        
    }
    
}