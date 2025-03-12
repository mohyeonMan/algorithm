package questions.programmers;

import java.util.LinkedList;
import java.util.Queue;

/*
 * rectangle	characterX	characterY	itemX	itemY	result
[[1,1,7,4],[3,2,5,5],[4,3,6,9],[2,6,8,8]]	1	3	7	8	17
[[1,1,8,4],[2,2,4,9],[3,6,9,8],[6,3,7,7]]	9	7	6	1	11
[[1,1,5,7]]	1	1	4	7	9
[[2,1,7,5],[6,4,10,10]]	3	1	7	10	15
[[2,2,5,5],[1,3,6,4],[3,1,4,6]]	1	4	6	3	10
 */
public class 아이템_줍기 {
    int w;
    int h;
    
    public int solution() {
        int[][] rectangle = {{2,1,7,5},{6,4,10,10}};
        int characterX = 3, characterY = 1, itemX = 7, itemY = 10;

        w = 0;
        h = 0;
        for(int[] rec : rectangle){
            w = Math.max(w,rec[2]);
            h = Math.max(h,rec[3]);
        }

        //그리드 확대
        w = w*2 + 1;
        h = h*2 + 1;

        //출발지 수정
        characterX = characterX * 2;
        characterY = characterY * 2;

        //목적지 수정
        itemX = itemX * 2;
        itemY = itemY * 2;
        
        boolean[][] boundary = new boolean[h][w];
        int[] offsetX = {-1,0,1,0};
        int[] offsetY = {0,-1,0,1};

        for (int[] rec : rectangle) {
            for(int y = rec[1] *2; y<= rec[3]*2; y++){
                for(int x = rec[0]*2; x<= rec[2]*2; x++){
                    boundary[y][x] = true;
                }
            }
        }

        for (int[] rec : rectangle) {
            for(int y = rec[1]*2 +1; y<= rec[3]*2 -1; y++){
                for(int x = rec[0]*2 +1; x<= rec[2]*2 -1; x++){
                    boundary[y][x] = false;
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{characterX, characterY, 0});

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int count = cur[2];
            if(x == itemX && y == itemY) return count/2;

            boundary[y][x] = false;

            for(int i = 0; i<4;i++){
                int nx = x + offsetX[i];
                int ny = y + offsetY[i];
                if(isValid(nx, ny) && boundary[ny][nx]){
                    queue.add(new int[]{nx,ny,count + 1});
                }
            }

        }

        return -1;

    }

    private boolean isValid(int x, int y){
        if(x <0 || y<0 || x>=w || y>=h) return false;
        return true;
    }
}
