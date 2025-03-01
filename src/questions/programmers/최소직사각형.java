package questions.programmers;
/*
 * sizes	result
[[60, 50], [30, 70], [60, 30], [80, 40]]	4000
[[10, 7], [12, 3], [8, 15], [14, 7], [5, 15]]	120
[[14, 4], [19, 6], [6, 16], [18, 7], [7, 11]]	133
 */
public class 최소직사각형 {
    
    
    public void solution(){
        int[][] sizes = {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}};
        
        int w = 0;
        int h = 0;
        for(int[] size : sizes){
            int max = Math.max(size[0],size[1]);
            int min = Math.min(size[0],size[1]);

            w = Math.max(max, w);
            h = Math.max(min, h);
        }

        System.out.println(w*h);
    }
}