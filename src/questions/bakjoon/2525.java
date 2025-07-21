import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        
        Scanner scanner = new Scanner(System.in);
        
        int hour = scanner.nextInt();
        int minute = scanner.nextInt();

        int time = scanner.nextInt();

        minute += time;

        if(minute > 59) {
            hour += minute / 60;
            minute = minute % 60;
        }
        if(hour > 23) hour -= 24;

        System.out.println(hour + " " + minute);
    }
}