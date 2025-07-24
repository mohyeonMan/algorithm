import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int rep = scanner.nextInt();
        
        while(rep-- > 0){
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            System.out.println(a+b);
        }
    }
}