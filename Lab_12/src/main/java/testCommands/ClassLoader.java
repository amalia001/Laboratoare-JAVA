package testCommands;
//package testCommands;
//
//import java.io.File;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.net.URLClassLoader;
//
//public class ClassLoader {
//    public ClassLoader(String path,String classname) throws ClassNotFoundException, MalformedURLException {
//        File f = new File(path);
//        URL[] cp = {f.toURI().toURL()};
//        URLClassLoader urlcl = new URLClassLoader(cp);
//        Class myclass  = urlcl.loadClass(classname);
//        for (Object i : myclass.getMethods() ) {
//            System.out.println(i.toString());
//        }
//    }
//
//    public ClassLoader() {
//
//    }
//}

import java.net.URL;
import java.net.URLClassLoader;

public class ClassLoader extends URLClassLoader {
    public ClassLoader() {
        super(new URL[0], ClassLoader.getSystemClassLoader());
    }
    @Override
    public void addURL(URL url) {
        super.addURL(url);
    }
}
