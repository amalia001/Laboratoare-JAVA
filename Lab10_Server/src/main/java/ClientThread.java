import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class ClientThread extends Thread {
    private boolean exit=false;
    private Socket socket = null ;
    //private String loggedUser="";
    public ClientThread (Socket socket) { this.socket = socket ; }
    public void run () {
        try {
            Network network=new Network();
            // Get the request from the input stream: client → server
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            while(true) {
                String request = in.readLine();
                //Network network=new Network();
                // Send the response to the oputput stream: server → client
                PrintWriter out = new PrintWriter(socket.getOutputStream());
                String raspuns = "";
                if (request.equals("stop")) {
                    raspuns = "Server stopped";
                    exit = true;

                } else
                    if (request.contains("register")) {
                        String name = request.substring(8);
                        network.addUser(name);
                        raspuns = name + " Registered!";
                        System.out.println("Users: " + network.getUsers());

                } else
                    if (request.contains("login")) {
                        String name = request.substring(5);
                        if (network.existsUser(name) == 1) {
                            raspuns = name + " Successfully logged in";
                            network.setLoggedUser(name);
                    }
                    else {
                        raspuns = "Login failed. User not registered";
                    }
                } else
                    if (request.contains("friend")) {
                        if (network.getLoggedUser() == "")
                            raspuns = "Nobody has logged in yet..Friendship couldn't be established";
                    else {
                        String friends = request.substring(6);
                        network.addFriends(network.getLoggedUser(), friends);
                        raspuns = "We added your friends!";
                    }
                } else
                    if (request.contains("send")) {
                    String mess = request.substring(4);
                    network.sendMessage(network.getLoggedUser(), mess);
                    raspuns = "We sent your message (" + mess + ") to all of your friends!"  ;

                } else
                    if (request.equals("read")) {
                    System.out.println(network.getMessagesSent());
                    raspuns = network.receiveMessage(network.getLoggedUser());

                } else
                {
                    raspuns = "Server received the request: " + request;
                }

                out.println(raspuns);

                out.flush();
            }
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