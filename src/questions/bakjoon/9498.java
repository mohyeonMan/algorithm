import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        int score = scanner.nextInt();

        String grade;

        if(isBetween(score, 90, 100)){
            grade = "A";
        }else if(isBetween(score, 80, 89)){
            grade = "B";
        }else if(isBetween(score, 70, 79)){
            grade = "C";
        }else if(isBetween(score, 60, 69)){
            grade = "D";
        }else grade = "F";

        System.out.println(grade);
    }

    private static boolean isBetween(int target, int from, int to){
        return from <= target && target <= to;
    }
}