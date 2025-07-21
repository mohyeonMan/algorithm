import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        int hour = scanner.nextInt();
        int minute = scanner.nextInt();

        minute -= 45;

        if(minute < 0){
            hour -= 1;
            minute +=60;
            if(hour < 0){
                hour +=24;
            }
        }

        System.out.println(hour + " " + minute);
        
    }

}