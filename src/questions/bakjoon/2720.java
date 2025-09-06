import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 코드 작성
        Scanner sc = new Scanner(System.in);
        int rep = Integer.parseInt(sc.nextLine());

        int[] ts = {25, 10, 5, 1};
        StringBuilder sb = new StringBuilder();
        while(rep-- > 0){
            int change = Integer.parseInt(sc.nextLine()) ;

            for(int t : ts){
                sb.append(change / t).append(" ");
                change = change % t;
            }
            sb.append("\t");
        }

        System.out.print(sb);
    }
}