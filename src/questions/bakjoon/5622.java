import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String l = sc.nextLine();

        int answer = l.length();
        for(char alp : l.toCharArray()){
            answer += getNumByAlp(alp);
        }

        System.out.print(answer);
    }

    private static int getNumByAlp(char alp){
        if(alp >= 'S') alp--;
        int n = alp - 'A' ;
        return Math.min(n / 3 + 2, 9);
    }
}