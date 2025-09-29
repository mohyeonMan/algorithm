import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        while(n > 1){
            for(int i = 2 ; i <= n; i++){
                if(n % i == 0){
                    System.out.println(i);
                    n = n / i;
                    break;
                }
            }
        }
        
    }
}