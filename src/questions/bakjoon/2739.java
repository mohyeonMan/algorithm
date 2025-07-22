import java.io.IOException;
import java.util.*;
class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for(int m = 1; m <= 9; m++ ){
            System.out.println(n + " * " + m +" = "+ (n * m));
        }
    }
}