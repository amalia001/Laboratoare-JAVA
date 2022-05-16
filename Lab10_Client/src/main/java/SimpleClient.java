import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SimpleClient {
    public static void main (String[] args) throws IOException {
        String serverAddress = "127.0.0.1"; // The server's IP address
        int PORT = 8100; // The server's port
        while (true) {
            try (
                    Socket socket = new Socket(serverAddress, PORT);
                    PrintWriter out =
                            new PrintWriter(socket.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(socket.getInputStream()))) {

                // Send a request to the server
                System.out.println("Your command:");
                Scanner sc = new Scanner(System.in);
                String request = sc.nextLine();
                if (request.equals("exit")) {
                    System.exit(0);
                }
                out.println(request);
                // Wait the response from the server ("Hello World!")
                String response = in.readLine();
                System.out.println(response);

            } catch (UnknownHostException e) {
                System.err.println("No server listening... " + e);
            }
        }

    }
}