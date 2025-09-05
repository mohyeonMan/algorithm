import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int max = -1;
        int x = -1;
        int y = -1;

        for(int i = 1; i <= 9; i++){
            String[] split = sc.nextLine().split(" ");
            for(int j = 1; j <= 9; j++){
                int num = Integer.parseInt(split[j - 1]);

                if(max <= num){
                    max = num;
                    x = j;
                    y = i;
                }
            }

        }

        System.out.print(max +"\n"+ y+" "+x);

    }
} 