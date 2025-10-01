import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        if(a + b + c == 180){
            if(a == 60 && b == 60 && c == 60) { System.out.print("Equilateral"); return; }
            if(a == b || b == c || c == a) { System.out.print("Isosceles"); return; }
            if(a != b && b != c && c != a) { System.out.print("Scalene"); return; }
        }
        else { System.out.print("Error"); return; }

    }
}