import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 코드 작성
        Scanner sc = new Scanner(System.in);
        Set<Integer> mods = new HashSet<>();
        
        int n = 10;
        while(n--> 0 ){
            mods.add(sc.nextInt() % 42);
        }

        System.out.print(mods.size());

    }
}