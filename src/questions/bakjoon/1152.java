import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String[] words = sc.nextLine().split(" ");

        long count = Arrays.stream(words).filter(w -> !w.isEmpty()).count();

        System.out.print(count);
    }
}