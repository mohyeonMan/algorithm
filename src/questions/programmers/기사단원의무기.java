package questions.programmers;

import java.util.HashMap;

public class 기사단원의무기 {
    
    public void execute(){

        int number = 10;
        int limit = 3;
        int power = 2;

        
    int answer = 0;

    for(int j = 1; j <= number; j++){
        

        int weaponCount =0;
        for (int i = 1; i <= j; i++){
            if(j % i == 0){
                    weaponCount ++;
                if(weaponCount > limit){
                    weaponCount = power;
                    break;
                }
            }
        }
        answer += weaponCount;
    }

    System.out.println(answer);


    }

}
