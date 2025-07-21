import java.io.IOException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int answer;
        
        if(isPositive(x)){
            if(isPositive(y)) answer = 1;
            else answer = 4;
        }else{
            if(isPositive(y)) answer = 2;
            else answer = 3;
        }

        System.out.println(answer);
                

    }

    private static boolean isPositive(int a){
        return a > 0;
    }

}