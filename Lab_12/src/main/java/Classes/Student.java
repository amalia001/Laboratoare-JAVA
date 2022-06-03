package Classes;

//public class Student {
//    private String name;
//    private int id;
//
//    public Student(String name, int id)
//    {
//        this.id=id;
//        this.name=name;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//
//}

import org.junit.jupiter.api.Test;

public class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Test
    public static void staticMethod1()
    {
        System.out.println("Method1");
    }

    @Test
    public static void staticMethod2()
    {
        throw new RuntimeException("RunTimeException");
    }


    public static void staticMethod3()
    {

    }
}