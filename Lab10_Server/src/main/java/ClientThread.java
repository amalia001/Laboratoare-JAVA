import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class ClientThread extends Thread {
    private boolean exit=false;
    private Socket socket = null ;
    public ClientThread (Socket socket) { this.socket = socket ; }
    public void run () {
        try {
            // Get the request from the input stream: client → server
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            String request = in.readLine();
            // Send the response to the oputput stream: server → client
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            String raspuns = "Server received request: " + request + "!";
            if(request.equals("stop")){
                raspuns="Server stopped";
                exit=true;
            }
            else {
                raspuns = "Server received request: " + request + "!";
            }
            out.println(raspuns);

            out.flush();
        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        } finally {
            try {
                socket.close(); // or use try-with-resources
            } catch (IOException e) { System.err.println (e); }
        }
        if(exit==true) {
            System.exit(0);
        }
    }

}