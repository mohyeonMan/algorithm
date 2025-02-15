package questions.programmers;


/*
    n	w	num	result
    22	6	8	3
    13	3	6	4
 */
public class 택배_상자_꺼내기_2 {


    public void solution(){

        int n = 22;
        int w = 6;
        int num = 8;

        int answer = 0;
        while (num <= n) { // num은 반드시 n보다 커야함.

            int index = (num - 1) % w; // 현재 num의 인덱스
            int diff = w - 1 - index; // 대칭이 되는 위치

            num += 2 * diff + 1; // 대칭이 되는 위치로 이동.
            answer ++;
        }
        System.out.println(answer);
    }
}