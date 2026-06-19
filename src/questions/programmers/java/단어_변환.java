package questions.programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
 * begin	target	words	return
"hit"	"cog"	["hot", "dot", "dog", "lot", "log", "cog"]	4
"hit"	"cog"	["hot", "dot", "dog", "lot", "log"]	0
 */
public class 단어_변환 {
    
    Set<String> wordSet;
    int len;

    public int solution(){

        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        len = begin.length();
        wordSet = new HashSet<>(Arrays.asList(words));


        if (!wordSet.contains(target)) return 0;

        Queue<Entry> queue = new LinkedList<>();
        queue.add(new Entry(begin,0));

        while(!queue.isEmpty()){
            
            Entry cur = queue.poll();
            String word = cur.value;
            int count = cur.count;

            if(word.equals(target)) return count;
            

            Iterator<String> it = wordSet.iterator();
            while (it.hasNext()) {
                String nWord = it.next();

                if (canConvert(word, nWord)) {
                    queue.add(new Entry(nWord, count + 1));
                    it.remove();
                }
            }

        }

        return 0;
    }

    private boolean canConvert(String word1, String word2) {
        int diff = 0;
        for (int i = 0; i < len; i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diff++;
                if (diff > 1) return false;
            }
        }
        return diff == 1;
    }

    class Entry{
        String value;
        int count;

        Entry(String value, int count){
            this.value = value;
            this.count = count;
        }
    }


}
