import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int[] lines = {a, b, c};
        Arrays.sort(lines);

        System.out.print(lines[0] + lines[1] + Math.min(lines[0] + lines[1] - 1, lines[2]));

    }
}