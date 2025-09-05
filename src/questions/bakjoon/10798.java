import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int h = 5;
        int w = 15;
        int maxX = -1;

        int[][] arr = new int[w][h];

        for(int i = 0; i< h; i ++){
            char[] chars = sc.nextLine().toCharArray();
            for(int j = 0; j< chars.length; j ++){
                char c = chars[j];
                arr[j][i] = c;
                maxX = Math.max(maxX, j);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int j = 0; j<= maxX; j ++){
            for(int i = 0; i< h; i ++){
                int cInt = arr[j][i];
                if(cInt == 0) continue;
                sb.append((char)cInt);
            }
        }
        System.out.print(sb.toString());

    }
} 