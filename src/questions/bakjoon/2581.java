import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();

        int sum = 0;
        int min = 10001; // M과 N의 최대값 + 1
        for(int i = M; i <= N; i ++){
            if(i == 1 || (i != 2 && i % 2 == 0)) continue; //1이거나 2의 배수인 경우 건너뜀

            int sqrt = (int)Math.floor(Math.sqrt(i));
            
            boolean isPrime = true;
            for(int j = 2; j <= sqrt; j++){
                if(i % j == 0) {
                    isPrime = false;
                    break;                    
                }
            }

            if(isPrime){
                sum += i;
                min = Math.min(min, i);
            }
        }

        if(sum == 0) System.out.println(-1);
        else {
            System.out.println(sum);
            System.out.println(min);
        }

    }
}