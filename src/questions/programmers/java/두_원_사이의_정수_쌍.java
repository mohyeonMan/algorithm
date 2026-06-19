package questions.programmers;


/*
    r1	r2	result
    2	3	20

    250213
    BFS론 풀수없는 문제. r2 <= 1_000_000 로 인해 메모리 초과.
    원 방정식을 사용해야할 것.
 */ 
public class 두_원_사이의_정수_쌍 {
    
    public void solution(){
        int r1 = 2;
        int r2 = 3;
        long answer = (long)(r2-r1+1)*4L;

        for (int x = 1; x <= r2; x++) {
            int yMax = (int)getY(x, r2);
            int yMin = (int)getY(x, r1);
            answer += (long)(yMax - yMin)*4;

            if(x<r1 && getY(x, r1)%1 ==0) answer += 4;
        }

        System.out.println(answer);
    }

    // x^2 + y^2 = r2 원의 방정식 이행한 형태태
    private double getY(int x, int r){
        return Math.sqrt((long)r*r-(long)x*x);
    }


}
