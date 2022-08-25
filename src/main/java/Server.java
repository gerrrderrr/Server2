import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int port = 8888;
        try (ServerSocket serverSocket = new ServerSocket(port);
             Socket clientSocket = serverSocket.accept();
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            System.out.println("Connected");
            out.println("Hi partner, tell me your name");
            final String name = in.readLine();
            out.println(String.format("Howdy %s, what about your lastname?", name));
            final String lastname = in.readLine();
            out.println(String.format("Nice to meet ya Mr. %s! How old are you?", lastname));
            final String age = in.readLine();
            out.println(String.format("You have probably seen soo many great things in your %s years! " +
                    "What path would you like to choose(wolf or deer)?", age));
            final String path = in.readLine();
            if (path.equals("wolf")) {
                out.println(String.format("So, I see wildness is in your blood, Mr. %s", lastname));
            } else if (path.equals("deer")) {
                out.println(String.format("I see kindness in your eyes, Mr. %s", lastname));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
