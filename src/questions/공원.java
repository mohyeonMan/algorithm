package questions;

import java.util.Arrays;

public class 공원 {
    public int execute(){
        
        int[] mats = {5,3,2};
        String[][] park = {{"A", "A", "-1", "B", "B", "B", "B", "-1"}, {"A", "A", "-1", "B", "B", "B", "B", "-1"}, {"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"}, {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"}, {"D", "D", "-1", "-1", "-1", "-1", "-1", "F"}, {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"}};

        Arrays.sort(mats);
        for(int m = mats.length-1 ; m > 0 ; m --){
            int mat = mats[m];
            for (int i = 0; i <= park.length - mat; i++) {
                for (int j = 0; j <= park[i].length - mat; j++) {  
                    if(isEmptySeat(park, i, j, mat))  return mat;  
                }
            }
        }

        return -1;

    }

    public boolean isEmptySeat(String[][] park, int x, int y){
        return park[x][y].equals("-1");
    }

    public boolean isEmptySeat(String[][] park, int x, int y, int size){
        
        for (int i = x; i < x + size ; i++) {
            for (int j = y; j < y + size ; j++) {
                if(!isEmptySeat(park, i, j)) return false;
            }
        }

        return true;
    }
}
