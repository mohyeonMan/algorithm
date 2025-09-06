import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine().toUpperCase();

        int[] count = new int[26];
        for (char c : text.toCharArray()) {
            count[c - 'A']++;
        }

        int max = -1;
        char answer = '?';
        for (int i = 0; i < 26; i++) {
            if (count[i] > max) {
                max = count[i];
                answer = (char)(i + 'A');
            } else if (count[i] == max) {
                answer = '?';
            }
        }

        System.out.println(answer);
    }
}