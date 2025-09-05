import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        boolean[][] board = new boolean[100][100];
        
        int rep = Integer.parseInt(sc.nextLine());

        int answer = 0;
        while(rep-- > 0){
            String[] split = sc.nextLine().split(" ");
            int startX = Integer.parseInt(split[0]);
            int startY = Integer.parseInt(split[1]);

            for(int y = startY ; y < startY + 10; y++){
                for(int x = startX ; x < startX + 10; x++){
                    if(board[x][y]) continue;

                    board[x][y] = true;
                    answer++;
                }
            }
        }

        System.out.print(answer);
    }
}