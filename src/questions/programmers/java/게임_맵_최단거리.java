package questions.programmers;

import java.util.LinkedList;
import java.util.Queue;

/*
 * maps	answer
[[1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1]]	11
[[1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1]]	-1
 */
public class 게임_맵_최단거리 {
    boolean[][] visited;
    int n;
    int m;
    int[] offsetX;
    int[] offsetY;

    public int solution(){

        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        
        n = maps.length;
        m = maps[0].length;
        offsetX = new int[]{-1,0,1,0};
        offsetY = new int[]{0,-1,0,1};

        visited = new boolean[n][m];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0,1});

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            int moves = cur[2];

            if(curX == m-1 && curY == n-1){
                return moves;
            }

            for(int i = 0; i<4 ; i++){
                int nx = curX + offsetX[i];
                int ny = curY + offsetY[i];
                if(isValid(nx, ny) && !visited[ny][nx] && maps[ny][nx] == 1){
                    visited[ny][nx] = true;
                    queue.add(new int[]{nx,ny,moves+1});
                }
            }

        }

        return -1;

    }


    private boolean isValid(int x, int y){
        if(x < 0 || x >= m || y < 0 || y>= n) return false;
        return true;  
    }
    
}