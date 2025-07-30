import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 코드 작성
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int max = -1;
        int sum = 0;

        for(int i = 0;i<n;i++){
            int score = sc.nextInt();
            sum += score;
            max = Math.max(max, score);
        }
        
        double avg = ((double)sum / n ) / max * 100;

        System.out.print(avg);
        
    }
}