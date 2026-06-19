package questions.programmers;


/*
    n	w	num	result
    22	6	8	3
    13	3	6	4
 */
public class 택배_상자_꺼내기 {

    int width;

    public void solution(){

        int n = 13;
        int w = 3;
        int num = 6;

        width = w;

        boolean currentDirection = true;
        int answer = 1;
        int offset = getOffset(num);

        while (true){
            num += w;
            if(currentDirection) num += offset;
            else num -= offset;
            if(n < num) break;

            answer ++;
            currentDirection = !currentDirection;
            
        }

        System.out.println(answer);


    }

    private int getOffset(int num){
        int mod = (num % width);
        int offset = -(width - 1);
        int range = isReversed(num)? width - mod : mod;
        for (int i = 0; i < range; i++) {
            offset +=2;            
        }

        return offset;
    }

    private boolean isReversed(int num){
        return (num / width + 1) % 2 == 0;
    }
}