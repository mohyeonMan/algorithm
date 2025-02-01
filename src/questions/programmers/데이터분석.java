package questions.programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class 데이터분석 {

    public void execute(){

        
        int[][] data = {{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}};
        String ext = "date";
        int val_ext = 20300501;
        String sort_by = "remain";
        
        ArrayList<int[]> answer = new ArrayList<>();

        Map<String,Integer> indexMap = new HashMap<>();
        indexMap.put("code", 0);
        indexMap.put("date", 1);
        indexMap.put("maximum", 2);
        indexMap.put("remain", 3);

        int sortIndex = indexMap.get(sort_by);
        int extIndex = indexMap.get(ext);
            
        for (int[] array : data) {
            if(array[extIndex] >= val_ext) continue;
            System.out.println("answer.length = " + answer.size());
            if(answer.size() == 0) answer.add(array);
            for (int i = 0; i< answer.size(); i ++) {

                int[] answerArr = answer.get(i);
                if(answerArr[sortIndex] > array[sortIndex]){
                    answer.add(i+1,answerArr);
                    answer.add(i, array);
                }else{
                    answer.add(array);
                }
                //     answer[i] = array;
            }
        }
        
        for (int[] is : answer) {
            for (int is2 : is) {
                System.out.print(is2 + "\t");
            }
            System.out.println();
        }

        
        
    }
}
