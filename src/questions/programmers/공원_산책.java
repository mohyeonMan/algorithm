package questions.programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/*
    park	routes	result
    ["SOO","OOO","OOO"]	["E 2","S 2","W 1"]	[2,1]
    ["SOO","OXX","OOO"]	["E 2","S 2","W 1"]	[0,1]
    ["OSO","OOO","OXO","OOO"]	["E 2","S 3","W 1"]	[0,0]
 */
public class 공원_산책 {
    
    private int w,h;
    private int[] start;
    private Map<String,int[]> offsetMap;
    private boolean[][] isWall;
    
    public void solution(){

        String[] park = {"OSO","OOO","OXO","OOO"};
        String[] routes = {"E 2","S 3","W 1"};
        
        init(park);

        for (String route : routes) {
            String[] s = route.split(" ");
            String d = s[0];
            int r = Integer.parseInt(s[1]);
            int[] offset = offsetMap.get(d);
            boolean isPossible = recursive(offset, start[0], start[1], r);
            
            if(isPossible){
                for (int i = 0; i < r; i++) {
                    start[0] += offset[0];
                    start[1] += offset[1];
                }
            }
            
        }
        
        System.out.println(Arrays.toString(start));

    }

    private void init(String[] park){

        h = park.length;
        w = park[0].length();

        offsetMap = new HashMap<>();
        isWall = new boolean[h][w];

        offsetMap.put("E", new int[]{0,1});
        offsetMap.put("W", new int[]{0,-1});
        offsetMap.put("N", new int[]{-1,0}); //상하 반대로되어있음.
        offsetMap.put("S", new int[]{1,0});

        for (int i = 0; i < h; i++) {
            String string = park[i];
            for (int j = 0; j < w; j++) {
                char al = string.charAt(j);
                if(al == 'O' || al == 'S'){
                    if(al == 'S'){
                        start = new int[]{i,j};
                    }
                    isWall[i][j] = false; 
                    continue;
                }
                isWall[i][j] = true;
            }
        }
    }

    private boolean isValid(int y, int x){
        if(y > h - 1 || x > w -1 || y < 0 || x < 0) return false;
        return true;
    }

    private boolean recursive(int[] offset, int curY, int curX, int count){
        if(!isValid(curY, curX) || isWall[curY][curX]) return false;
        if(count == 0 ) return true;
        return recursive(offset, curY + offset[0], curX + offset[1], count - 1);
    }
}
