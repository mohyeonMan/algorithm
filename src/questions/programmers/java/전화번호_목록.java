package questions.programmers;

import java.util.Arrays;
import java.util.Set;

/*
 * phone_book	return
    ["119", "97674223", "1195524421"]	false
    ["123","456","789"]	true
    ["12","123","1235","567","88"]	false
 */
public class 전화번호_목록 {

    public void solution() {
        String[] phone_book = {"123","456","789"};

        Arrays.sort(phone_book);
        
        boolean answer = false;
        for(int i = 1; i < phone_book.length; i ++){
            if(phone_book[i].startsWith(phone_book[i-1])){
                answer = true;
                break;
            }
        }
        
        System.out.println(answer);
    }

}