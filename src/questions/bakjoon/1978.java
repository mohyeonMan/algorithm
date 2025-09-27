import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int answer = 0;
        
        while(n-- > 0){
            int t = sc.nextInt();
            if(t == 1) continue;

            int sqrt = (int)Math.floor(Math.sqrt(t));
            boolean isPrime = true;
            
            for(int i = 2; i<= sqrt; i++){
                if(t % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            if(isPrime) answer ++;
            
        }

        System.out.print(answer);
    }
}