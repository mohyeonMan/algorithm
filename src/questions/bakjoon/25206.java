import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int rep = 20;

        double pointSum = 0;
        double totalSum = 0;

        while(rep-- > 0){
            String[] split = sc.nextLine().split(" ");
            double point = Double.parseDouble(split[1]);
            String score = split[2];
            
            if(score.equals("P")) continue;
            
            pointSum += point;
            totalSum += point * getScore(score);

        }

        System.out.println(totalSum / pointSum);
    }

    public static double getScore(String scoreAlp){
        if(scoreAlp.equals("F")) return 0;

        double score = 4 - (scoreAlp.charAt(0) - 'A');
        if(scoreAlp.charAt(1) == '+') score += 0.5;

        return score;
        
    }
}