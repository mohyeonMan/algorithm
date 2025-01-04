package questions;

public class 대소문자바꿔출력하기 {
    public void execute(){

        String str = "zaAbBcC";

        str.chars().forEach(i -> {
            System.out.print((char)(Character.isUpperCase(i)? i+32:i-32));
        });

    }

}
