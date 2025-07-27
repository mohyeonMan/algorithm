import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 코드 작성
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 바구니 수
        int m = sc.nextInt(); // 공을넣는 횟수.
        sc.nextLine();

        int[] baskets = new int[n];

        while(m-- > 0){
            String[] split = sc.nextLine().split(" ");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);

            int from = Math.min(a,b) - 1;
            int to = Math.max(a,b) - 1;
            int ball = Integer.parseInt(split[2]);

            for(int i = from; i <= to; i++){
                baskets[i] = ball;
            }
        }

        for(int basket : baskets){
            System.out.print(basket + " ");
        }
        

    }
}