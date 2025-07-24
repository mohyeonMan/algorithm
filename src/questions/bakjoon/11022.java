import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 코드 작성
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(r.readLine());

        for(int i = 1; i<= t; i++){
            String[] l = r.readLine().split(" ");
            int a = Integer.parseInt(l[0]);
            int b = Integer.parseInt(l[1]);
            w.write("Case #"+i+": "+a+" + "+b+" = "+(a+b));
            w.newLine();
        }

        w.close();
        r.close();
    }
}