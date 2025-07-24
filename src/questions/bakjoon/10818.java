import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 코드 작성
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        
        int min = 1_000_000;
        int max = -1_000_000;
        
        while(n-- > 0){
            int t = sc.nextInt();
            min = Math.min(min, t);
            max = Math.max(max, t);
        }

        System.out.println(min + " " + max);
    }
}