import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int cur = 0;
        for(int i = 1; i <= N; i++){
            if(N % i == 0) {
                if(K == ++cur) {
                    System.out.println(i);
                    return;
                }
            }
        }

        System.out.println(0);
        
    }
}