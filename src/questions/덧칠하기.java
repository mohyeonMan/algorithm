package questions;
public class 덧칠하기 {

    public void execute(){

        int n = 5; //벽길이
        int m = 4; //롤러길이
        int[] section = {1,3};

        int current = 0;   
        int times = 0;         
        for(int wall : section){
            if(wall > current){
                current = wall+m-1;
                times ++;
            }
            if(current > n){
                break;
            }
        }
        System.out.println(times);

    }

}
