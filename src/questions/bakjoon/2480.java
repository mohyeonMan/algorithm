import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner  = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        int price;
        
        if(a == b && b == c) price = 10000 + a * 1000;
        else if( a == b || b == c ) price = 1000 + b * 100;
        else if( a == c ) price = 1000 + a * 100;
        else {
            int max = Math.max(a,Math.max(b, c));
            price = max * 100;
        }

        System.out.println(price);

    }
}