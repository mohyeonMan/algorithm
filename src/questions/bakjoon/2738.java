import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int rep = 2;


        int[][] arr = new int[m][n];

        while(rep-- > 0){
            for(int y = 0; y < n; y++){
                for(int x = 0; x < m; x++){
                    arr[x][y] += sc.nextInt();
                }
            }
        }

        for(int y = 0; y < n; y++){
            for(int x = 0; x < m; x++){
                System.out.print(arr[x][y] +" ");    
            }
            System.out.println();
        }

    }
}