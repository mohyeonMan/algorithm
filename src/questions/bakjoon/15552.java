import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 코드 작성
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(reader.readLine());

        while(t-- > 0){
            String[] line = reader.readLine().split(" ");
            writer.write(
                String.valueOf(Integer.parseInt(line[0]) + Integer.parseInt(line[1]))
            );
            writer.newLine();
        }

        writer.flush();
        writer.close();
    }
}