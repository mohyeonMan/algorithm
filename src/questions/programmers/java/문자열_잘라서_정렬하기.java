package questions.programmers;

import java.util.ArrayList;
import java.util.List;

public class 문자열_잘라서_정렬하기{

    public void solution(){
        String myString = "dxccxbbbxaa aax ";

        String[] split = myString.split("x");
        List<String> temp = new ArrayList<>();
        for (String string : split) {
            if(string.trim().length() == 0) continue;
            temp.add(string);
        }

        temp.toArray(new String[temp.size()]);
    }
}