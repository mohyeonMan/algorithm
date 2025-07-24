import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 코드 작성
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(r.readLine());

        for(int i = 1; i<= t; i++){
            String[] l = r.readLine().split(" ");
            w.write("Case #");
            w.write(String.valueOf(i));
            w.write(": ");
            w.write(String.valueOf(Integer.parseInt(l[0])+Integer.parseInt(l[1])));
            w.newLine();
        }

        w.flush();
        w.close();
    }
}