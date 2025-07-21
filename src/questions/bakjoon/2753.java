import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int result = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)?
             1 : 0;
        
        System.out.print(result);        

    }

}