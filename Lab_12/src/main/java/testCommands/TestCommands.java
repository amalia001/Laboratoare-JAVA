//package testCommands;
//
//import java.io.IOException;
//import java.util.Scanner;
//import Classes.*;
//
//public class TestCommands {
//
//    public static void main(String args[]) throws IOException {
//        Scanner scanner = new Scanner(System.in);
//        while (true) {
//            String commandName = scanner.next();
//            if (commandName.equalsIgnoreCase("exit")) {
//                break;
//            }
//            String[] params = scanner.nextLine().trim().split("\\s+");
//            //String[] params = scanner.nextLine();
//            try {
//                // The command name is actually the class name
//                Class clazz = Class.forName(commandName);
//                Command command = (Command) clazz.newInstance();
//                command.execute(params);
//            } catch (ClassNotFoundException | InstantiationException |
//                    IllegalAccessException | IOException e) {
//                System.err.println(e);
//            }
//        }
//    }
//
//
//
//    public static void main(String args[]) throws IOException, ClassNotFoundException {
//        Scanner scanner = new Scanner(System.in);
//        while (true) {
//            String commandName = scanner.next();
//            if (commandName.equalsIgnoreCase("exit")) {
//                break;
//            }
//            String path = "", classname = "";
//            StringBuilder sb = new StringBuilder("");
//            String[] params = scanner.nextLine().trim().split("/");
//            for(String par : params) {
//                if (par.equals(params[params.length-1])) {
//                    classname = par;
//                }else {
//                    path += par + "/";
//                }
//            }
//            path = sb.toString();
//            ClassLoader classLoader = new ClassLoader(path,classname);
//
//        }
//    }
//}