package CodeSegment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DataType {

    public static void main(String[] args) {
        System.out.println("Hello DataType!");
        arrayListType2();
    }

    //byte类型
    public static void byteType() {
        byte a = 10;
        byte b = 20;
        byte c = (byte) (a + b);
        System.out.println(c);
    }

    //short类型
    public static void shortType() {
        short a = 10;
        short b = 20;
        short c = (short) (a + b);
        System.out.println(c);
    }

    //int类型
    public static void intType() {
        int a = 10;
        int b = 20;
        int c = a + b;
        System.out.println(c);
    }

    //long类型
    public static void longType() {
        long a = 10;
        long b = 20;
        long c = a + b;
        System.out.println(c);
    }

    //char类型
    public static void charType() {
        char a = 'a';
        char b = 'b';
        char c = (char) (a + b);
        System.out.println(c);
    }    
    
    //float类型
    public static void floatType() {
        float a = 10.0f;
        float b = 20.0f;
        float c = a + b;
        System.out.println(c);
    }

    //double类型
    public static void doubleType() {
        double a = 10.0;
        double b = 20.0;
        double c = a + b;
        System.out.println(c);
    }

    //boolean类型
    public static void booleanType() {
        boolean a = true;
        boolean b = false;
        System.out.println(a);
        System.out.println(b);
    }

    //String类型
    public static void stringType() {
        String a = "Hello";
        String b = "World";
        String c = a + b;
        System.out.println(c);
    }    

    //Array类型:数组
    public static void arrayType() {
        int[] a = new int[10];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static void arrayType2() {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    //ArrayList类型:集合/数组列表
    public static void arrayListType() {
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        a.add(6);
        a.add(7);
        a.add(8);
        a.add(9);
        a.add(10);
        for (int i = 0; i < a.size(); i++) {
            System.out.println(a.get(i));
        }
    }

    //ArrayList<Student>
    public static void arrayListType2() {
        ArrayList<Student> a = new ArrayList<Student>();
        a.add(new Student("张三", 20, 100));
        a.add(new Student("李四", 21, 200));
        a.add(new Student("王五", 22, 300));
        a.add(new Student("赵六", 23, 400));
        a.add(new Student("孙七", 24, 500));
        a.add(new Student("周八", 25, 600));
        a.add(new Student("吴九", 26, 700));
        a.add(new Student("郑十", 27, 800));
        a.add(new Student("王十一", 28, 900));
        a.add(new Student("李十二", 29, 1000));
        for (int i = 0; i < a.size(); i++) {
            System.out.println(a.get(i));
        }
    }

    //Map类型:键值对
    public static void mapType() {
        Map<String, Integer> a = new HashMap<String, Integer>();
        a.put("a", 1);
        a.put("b", 2);
        a.put("c", 3);
        a.put("d", 4);
        a.put("e", 5);
        a.put("f", 6);
        a.put("g", 7);
        a.put("h", 8);
        a.put("i", 9);
        a.put("j", 10);
        for (Map.Entry<String, Integer> entry : a.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    //interface类型:接口
    // public static void interfaceType() {
    //     Interface1 a = new Interface1() {
    //         @Override
    //         public void print() {
    //             System.out.println("Hello Interface!");
    //         }
    //     };
    //     a.print();
    // }
}
