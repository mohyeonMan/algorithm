package questions;

public class 비밀지도 {
    public void execute(){

        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        
        String[] resultArr= new String[n];
        
        int deviderOrigin = 1;
        for(int i = 1; i<n; i++){
            deviderOrigin = deviderOrigin * 2;
        }
        
        for(int i = 0; i < n; i++){
            int devider = deviderOrigin;
            String result = "";
            for(int j = 0; j < n; j++){
                
                boolean isWall = false;
                
                if(isWall(devider, arr1[i])){
                    arr1[i] = arr1[i] - devider;
                    isWall = true;
                }
                
                if(isWall(devider, arr2[i])){
                    arr2[i] = arr2[i] - devider;
                    isWall = true;
                }
                
                if(isWall){
                    result += "#";
                }else{
                    result += " ";
                }
                
                devider = devider / 2;
            }
            resultArr[i] = result;
        }
        
        String[] answer = resultArr;
        
    }
    
    public boolean isWall(int devider, int value){
        return (value / devider >0);
    }
}
