import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 코드 작성
        Scanner scanner = new Scanner(System.in);

        final int n = scanner.nextInt(), x = scanner.nextInt(); 
        scanner.nextLine();
        Arrays.stream(scanner.nextLine().trim().split(" "))
            .map(Integer::valueOf)
            .filter(i -> i < x)
            .forEach(i -> System.out.print(i + " "));
    }
}