import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        int price = scanner.nextInt();
        int count = scanner.nextInt();
        
        while(count-- > 0){
            price -= scanner.nextInt() * scanner.nextInt();
        }

        System.out.println(price == 0? "Yes" : "No");

    }
}