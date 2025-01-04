package questions;

public class 카드뭉치 {

    public void execute(){

        String[] cards1 = {"i", "drink", "water"};
        String[] cards2 = {"want", "to"};
        
        String[] goal = {"i", "want", "to", "drink", "water"};

        String answer = "Yes";
        int current1 = 0;
        int current2 = 0;
        for (String word : goal){

            boolean exist = false;
            if(word.equals(cards1[current1])){
                if(cards1.length-2 >= current1){
                    current1++;
                }
                exist = true;
            }
            if(word.equals(cards2[current2])){
                if(cards2.length-2 >= current2){
                    current2++;
                }
                exist = true;
            }

            if(!exist){
                answer = "No";
                break;
            }
        }
        System.out.println(answer);
    }

}
