package questions.programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * name	return
"JEROEN"	56
"JAN"	23
 */
public class 조이스틱 {
    int min;
    int len;
    int mapSize;
    boolean[] visited;
    Map<Integer,Character> indexCharMap;

    public void solution(){
        String name = "JEROEN";

        len = name.length();
        min = Integer.MAX_VALUE;
        visited = new boolean[name.length()];
        indexCharMap = new HashMap<>();
        for(int i = 0; i<len;i++){
            if(name.charAt(i) == 'A') visited[i] = true;
            else indexCharMap.put(i, name.charAt(i));
        }
        mapSize = indexCharMap.size();

        dfs(0, 0, 0);

        System.out.println(min);
    }

    private void dfs(int position, int moves, int count){
        if(count == mapSize){
            min = Math.min(moves, min);
            return;
        }
        
        for(int i = 0; i<len; i++){
            if(!visited[i]){
                visited[i] = true;
                int idxDist = getIdxDist(position, i);
                int alpDist = getAlpDist('A', indexCharMap.get(i));
                dfs(i, moves + idxDist + alpDist, count+1);
                visited[i] = false;
            }
        }

    }

    private int getAlpDist(char from, char to){
        return Math.min(to - from, 'Z' - to + 1);
    }

    private int getIdxDist(int from, int to) {
        return Math.min(Math.abs(to - from), len - Math.abs(to - from));
    }
    

}
