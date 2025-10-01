import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        while(true){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            if(a == 0 && b == 0 && c == 0) break;
            
            int[] sorted = new int[]{a, b ,c};
            Arrays.sort(sorted);
            
            if(sorted[2] >= sorted[1] + sorted[0]) { System.out.println("Invalid"); continue; }
            
            if(a == b && b == c && c == a) { System.out.println("Equilateral"); continue; }
            if(a == b || b == c || c == a) { System.out.println("Isosceles"); continue; }
            if(a != b && b != c && c != a) { System.out.println("Scalene"); continue; }
        }

    }
}