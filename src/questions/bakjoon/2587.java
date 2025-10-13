import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 코드 작성
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[5];
        
        arr[0] = sc.nextInt();
        arr[1] = sc.nextInt();
        arr[2] = sc.nextInt();
        arr[3] = sc.nextInt();
        arr[4] = sc.nextInt();
        
        Arrays.sort(arr);
        
        System.out.println((int)Arrays.stream(arr).average().orElseGet(() -> 0));
        System.out.println(arr[2]);

        
    }
}