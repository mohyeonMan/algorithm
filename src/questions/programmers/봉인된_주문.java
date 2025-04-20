package questions.programmers;

import java.util.*;

/*
 * n	bans	result
30	["d", "e", "bb", "aa", "ae"]	"ah"
7388	["gqk", "kdn", "jxj", "jxi", "fug", "jxg", "ewq", "len", "bhc"]	"jxk"
 */
public class 봉인된_주문 {
    
    public String solution(){

        int n = 7388;
        String[] bans = {"gqk", "kdn", "jxj", "jxi", "fug", "jxg", "ewq", "len", "bhc"};

        // banned 문자열을 숫자로 바꿔 길이별로 저장
        Map<Integer, Set<Long>> blocked = new HashMap<>();
        for (String s : bans) {
            blocked.computeIfAbsent(s.length(), k -> new HashSet<>()).add(toNumber(s));
        }

        int len = 1;
        while (true) {
            long total = (long) Math.pow(26, len);
            long bannedCount = blocked.getOrDefault(len, Set.of()).size();
            long valid = total - bannedCount;

            if (n <= valid) break;
            n -= valid;
            len++;
        }

        for (long i = 0, count = 0; i < (long)Math.pow(26, len); i++) {
            if (blocked.getOrDefault(len, Set.of()).contains(i)) continue;
            if (++count == n) {
                String answer = toString(i, len);
                System.out.println(answer);
                return answer;
            }
        }

        return null;

    }

    public static long toNumber(String s) {
        long num = 0;
        for (char c : s.toCharArray()) {
            num = num * 26 + (c - 'a');
        }
        return num;
    }

    public static String toString(long num, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append((char) ('a' + (int)(num % 26)));
            num /= 26;
        }
        return sb.reverse().toString();
    }

    

    
}
