package questions.programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/*
    wallpaper	result
    [".#...", "..#..", "...#."]	[0, 1, 3, 4]
    ["..........", ".....#....", "......##..", "...##.....", "....#....."]	[1, 3, 5, 8]
    [".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."]	[0, 0, 7, 9]
    ["..", "#."]
 */
public class 바탕화면_정리 {
    private int w,h;
    private Map<String,Integer> minMaxMap;

    public void solution(){
        String[] wallPaper = {"..........", ".....#....", "......##..", "...##.....", "....#....."};

        init(wallPaper);

        for(int y = 0 ; y < h ; y++){
            String row = wallPaper[y];
            for(int x = 0; x < w ; x++){
                char file = row.charAt(x);
                if(file == '#'){
                    putMinMax(y, x);
                }
            }
        }

        System.out.println(Arrays.toString(new int[]{
            minMaxMap.get("yMin"),
            minMaxMap.get("xMin"),
            minMaxMap.get("yMax"),
            minMaxMap.get("xMax")
        }));
    }

    private void init(String[] wallPaper){
        h = wallPaper.length;
        w = wallPaper[0].length();

        minMaxMap = new HashMap<>();
    }

    private void putMinMax(int y, int x){
        minMaxMap.put("xMin", Math.min(minMaxMap.getOrDefault("xMin", Integer.MAX_VALUE), x));
        minMaxMap.put("xMax", Math.max(minMaxMap.getOrDefault("xMax", 0), x + 1));
        minMaxMap.put("yMin", Math.min(minMaxMap.getOrDefault("yMin", Integer.MAX_VALUE), y));
        minMaxMap.put("yMax", Math.max(minMaxMap.getOrDefault("yMax", 0), y + 1));
    }
}
