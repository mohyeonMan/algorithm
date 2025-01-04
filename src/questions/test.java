package questions;

public class test {
    
    public void execute(){

        String myString = "abcdefghijk";
        String overWrite = "123";
        int s = 3;

        String start = myString.substring(0, s);
        String end = myString.substring(s+overWrite.length());

        System.out.println(start + overWrite + end);
    }
}
