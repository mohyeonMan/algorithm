package questions.programmers;

import java.util.ArrayDeque;
import java.util.Queue;

/*
    r1	r2	result
    2	3	20

    250213
    BFS론 풀수없는 문제. r2 <= 1_000_000 로 인해 메모리 초과.
    원 방정식을 사용해야할 것.
 */ 
public class 두_원_사이의_정수_쌍 {
    int min,max;
    boolean visited[][];
    int[] offsetX = {1,0};
    int[] offsetY = {0,1};
    
    public void solution(){
        int r1 = 2;
        int r2 = 3;

        min = r1;
        max = r2;
        visited = new boolean[r2+2][r2+2];

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0,0});
        long answer = 0;

        while (!queue.isEmpty()){
            
            int[] c = queue.poll();
            int y = c[0];
            int x = c[1];
            
            for(int o = 0 ; o < 2; o++){
                int ny = y + offsetY[o];
                int nx = x + offsetX[o];
                
                if(visited[ny][nx]) continue;
                visited[ny][nx] = true;
                
                double length = getLength(ny, nx);
                if(length <= max){
                    queue.add(new int[]{ny,nx});
                    if(min <= length && nx != 0){
                        System.out.println(ny +", "+nx );
                        answer ++;
                    }
                }
            }
        }

        System.out.println(answer * 4);

    }

    private double getLength(int y, int x){
        return Math.sqrt(x * x + y * y);
    }


}
