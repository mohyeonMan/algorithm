import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int n = 3;

        Set<String> points = new HashSet<>();
        int minx = 1001;
        int maxx = 0;
        int miny = 1001;
        int maxy = 0;

        while(n-- > 0){
            int x = sc.nextInt();
            int y = sc.nextInt();

            minx = Math.min(x, minx);
            maxx = Math.max(x, maxx);
            miny = Math.min(y, miny);
            maxy = Math.max(y, maxy);

            points.add(x+"_"+y);
        }

        if(!points.contains(minx+"_"+miny)) System.out.print(minx+" "+miny);
        if(!points.contains(minx+"_"+maxy)) System.out.print(minx+" "+maxy);
        if(!points.contains(maxx+"_"+miny)) System.out.print(maxx+" "+miny);
        if(!points.contains(maxx+"_"+maxy)) System.out.print(maxx+" "+maxy);

    }
}