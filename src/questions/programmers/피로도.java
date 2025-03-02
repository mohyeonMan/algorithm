package questions.programmers;

import java.util.LinkedList;
import java.util.Queue;

/*
 * k	dungeons	result
80	[[80,20],[50,40],[30,10]]	3
 */
public class 피로도 {

    int max = 0;
    int len;
    boolean[] visited;
    int[][] dungeons;

    public void solution(){
        int k = 80;
        int[][] dungeons = {{80,20},{50,40},{30,10}};

        this.max = 0;
        this.dungeons = dungeons;
        this.len = dungeons.length;
        this.visited = new boolean[len];

        dfs(k, 0);

        System.out.println(max);
    }

    private void dfs(int currentK, int count){
        max = Math.max(max, count);

        for (int i = 0; i < len; i++) {
            if (!visited[i] && currentK >= dungeons[i][0]) {
                visited[i] = true;
                dfs(currentK - dungeons[i][1], count + 1);
                visited[i] = false;
            }
        }  

    }
    
}
