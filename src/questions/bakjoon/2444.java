import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int rep = n + n - 1;
        int range = 0;

        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < rep; r++) {
            if (r < n) range++;
            else range--;

            int left = n - range + 1;
            int right = n + range - 1;

            for (int c = 1; c <= right; c++) {
                sb.append(c >= left ? '*' : ' ');
            }
            sb.append('\n');
        }
        System.out.print(sb.toString());
    }
}