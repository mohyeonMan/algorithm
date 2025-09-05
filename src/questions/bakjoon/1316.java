import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int rep = Integer.parseInt(sc.nextLine());

        int answer = 0;
        while(rep-- > 0){
            if(isGroup(sc.nextLine())) answer ++;
            
        }

        System.out.println(answer);

        
    }

    private static boolean isGroup(String text){
        char[] chars = text.toCharArray();
        Map<Character, Integer> recents = new HashMap<>();

        for(int i = 0; i < chars.length; i++){
            char c = chars[i];
            int recent = recents.getOrDefault(c,  i - 1); // 2. 처음 발견된 문자인 경우, i - 1 로 넣어 아래 조건을 만족시키도록 함.
            if((i - 1) != recent) return false; // 1. 해당 문자의 직전 인덱스와 연속하지 않는다면, 그룹이 아님.

            recents.put(c, i);
        }

        return true;
    }

}