import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;

public class User {
    public static void main(String[] args) {
        String host = "netology.homework";
        int port = 8888;
        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            List<String> answers = Arrays.asList("Arthur", "Morgan", "40", "wolf");
            for (String answer : answers) {
                String q = in.readLine();
                System.out.println(q);
                out.println(answer);
            }
            String destiny = in.readLine();
            System.out.println(destiny);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
