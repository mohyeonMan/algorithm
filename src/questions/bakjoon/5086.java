import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        
        String p;

        while(true){

            String[] split = sc.nextLine().split(" ");
            int v1 = Integer.parseInt(split[0]);
            int v2 = Integer.parseInt(split[1]);

            if(v1 == 0 && v2 == 0) break;

            if(v1 < v2 && v2 % v1 == 0){
                p = "factor";
            }else if(v1 > v2 && v1 % v2 == 0){
                p = "multiple";
            }else{
                p = "neither";
            }

            System.out.println(p);
        }
    }
}