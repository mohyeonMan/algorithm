import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 코드 작성
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int k = sc.nextInt();
        
        int[] ls = new int[N];
        for(int i = 0; i<N; i++){
            ls[i] = sc.nextInt();
        }

        Arrays.sort(ls);

        System.out.print(ls[N - k]);
        
    }
}