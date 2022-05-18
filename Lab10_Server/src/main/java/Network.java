import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Network {
    private List<String> users=new ArrayList<>();
    private Map<String, List<String>> friendship=new HashMap<>();
    private String loggedUser = new String();
    private Map<String, List<String>> messagesSent = new HashMap<>();

    public Network(){}

    public void addUser(String user){
        users.add(user);
    }

    public  List<String> getUsers(){
        return users;
    }

    public  int existsUser(String u)
    {
        if(users.contains(u)) return 1;
        return 0;
    }

    public  String getLoggedUser() {
        return loggedUser;
    }

    public  void setLoggedUser(String loggedUser) {
        this.loggedUser = loggedUser;
    }

    public void addFriends(String name, String allFriends){
        String[] arrayOfFriends  = allFriends.split(",");
        List<String> friendList = new ArrayList<>();
        for(String friend:arrayOfFriends)
            friendList.add(friend);
        friendship.put(name, friendList);
    }

    public  Map<String, List<String>> getFriendship() {
        return friendship;
    }

    public  void sendMessage(String username, String message){
        List<String> messageList=new ArrayList<>();
        List<String> friends=friendship.get(username);
        for(String friend : friends){
            if(messagesSent.get(friend)!=null)
                messageList=messagesSent.get(friend);
            messageList.add(message);
            System.out.println("User" + username+ " sent the message '" + message + "' to "+ friend);
            messagesSent.put(friend, messageList);
        }
    }

    public  Map<String, List<String>> getMessagesSent() {
        return messagesSent;
    }

    public  String receiveMessage(String username){
        StringBuilder sb=new StringBuilder("");
        List<String> messagesReceived=messagesSent.get(username);
        for(String message : messagesReceived){
            sb.append(message);
            sb.append("\n");
        }
        String mess=sb.toString();
        return mess;
    }

    @Override
    public String toString() {
        return "Network{" +
                "users=" + users +
                '}';
    }
}
