import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 코드 작성
        Scanner sc = new Scanner(System.in);
        int[] chess = {1,1,2,2,2,8};

        for(int i =0; i<chess.length;i++){
            int n = sc.nextInt();
            System.out.print(chess[i] - n + " ");
        }
    }
}