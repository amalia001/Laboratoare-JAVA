package testCommands;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        try {
            compulsory();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


    }

    public static void compulsory() throws ClassNotFoundException, MalformedURLException {
        ClassLoader classLoader = new ClassLoader();
        int passed = 0;
        int failed = 0;

        for(Method method : classLoader.loadClass("Classes.Student").getMethods()){
            System.out.print(method.getReturnType() + " " + method.getName() + "(");
            boolean first = true;
            for (var i : method.getParameters()) {
                if (first) {
                    System.out.print(i.getType().toGenericString() + " " + i.getName());
                    first = false;
                } else {
                    System.out.print(", " + i.getType().toGenericString() + " " + i.getName());
                }
            }
            System.out.print(");"+"\n");
        }
        System.out.println();
        for (Method method : classLoader.loadClass("Classes.Student").getMethods()) {
            if (method.isAnnotationPresent(Test.class)) {
                try {
                    method.invoke(null);
                    passed++;
                } catch (Throwable throwable)
                {
                    System.out.printf("Test %s failed: %s  %n", method, throwable.getCause());
                    failed++;
                }
            }
        }
        System.out.printf("Passed: %d, Failed %d%n", passed, failed);
    }




}
