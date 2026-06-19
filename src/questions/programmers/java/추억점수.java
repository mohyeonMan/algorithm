package questions.programmers;
import java.util.HashMap;

public class 추억점수 {

    public void execute() {
        String[] name = { "may", "kein", "kain", "radi" };
        int[] yearning = { 5, 10, 1, 3 };

        String[][] photo = { { "may", "kein", "kain", "radi" }, { "may", "kein", "brin", "deny" },
                { "kon", "kain", "may", "coni" } };

        int[] answer = new int[photo.length];

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }

        for (int i = 0; i < photo.length; i++) {
            int score = 0;
            for (int j = 0; j < photo[i].length; j++) {

                score += map.getOrDefault(photo[i][j], 0);
            }
            answer[i] = score;
        }
    }

}
