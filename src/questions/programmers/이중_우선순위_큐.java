package questions.programmers;

import java.util.Arrays;
import java.util.TreeSet;
/*
 * operations	return
["I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"]	[0,0]
["I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"]	[333, -45]
 */
public class 이중_우선순위_큐 {
    
    
    public void solution(){
        
        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        
        TreeSet<Integer> treeSet = new TreeSet<>();
        for(String operation : operations){
            String[] split = operation.split(" ");

            if(split[0].equals("D")){
                if(treeSet.isEmpty()) continue;
                
                if(split[1].equals("-1")) treeSet.pollFirst();
                else treeSet.pollLast();
            }else{
                treeSet.add(Integer.parseInt(split[1]));
            }

        }

        int[] answer = treeSet.isEmpty()? new int[]{0,0} : new int[]{treeSet.last(),treeSet.first()};
     
        System.out.println(Arrays.toString(answer));
    }
}
