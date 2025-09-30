import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int minx = 10001;
        int miny = 10001;
        int maxx = -10001;
        int maxy = -10001;
        while(n-- > 0){
            int x = sc.nextInt();
            int y = sc.nextInt();

            minx = Math.min(x, minx);
            miny = Math.min(y, miny);
            maxx = Math.max(x, maxx);
            maxy = Math.max(y, maxy);
        }

        System.out.print(
            (maxx - minx) * (maxy - miny)
        );

    }
}