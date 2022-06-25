package CodeSegment;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GeneralSort{

    public static void main(String[] args) {
        System.out.println("Hello GeneralSort!");

        //模拟20个不同学生对象
        Student stu1 = new Student("张三", 20, 100,1);
        Student stu2 = new Student("李四", 21, 200,0);
        Student stu3 = new Student("王五", 22, 300,1);
        Student stu4 = new Student("赵六", 23, 400,0);
        Student stu5 = new Student("孙七", 24, 500,1);
        Student stu6 = new Student("周八", 25, 600,0);
        Student stu7 = new Student("吴九", 26, 700,1);
        Student stu8 = new Student("郑十", 27, 800,0);
        Student stu9 = new Student("王十一", 28, 900,1);
        Student stu10 = new Student("李十二", 29, 1000,0);
        Student stu11 = new Student("张十三", 30, 1100,1);
        Student stu12 = new Student("李十四", 31, 1200,0);
        Student stu13 = new Student("王十五", 32, 1300,1);
        Student stu14 = new Student("赵十六", 33, 1400,0);
        Student stu15 = new Student("孙十七", 34, 1500,1);
        Student stu16 = new Student("周十八", 35, 1600,0);
        Student stu17 = new Student("吴十九", 36, 1700,1);
        Student stu18 = new Student("郑二十", 37, 1800,0);
        Student stu19 = new Student("王二十一", 38, 1900,1);
        Student stu20 = new Student("李二十二", 39, 2000,0);
        
        //List 容器存储学生对象
        List<Student> list = new java.util.ArrayList<Student>();
        list.add(stu1);
        list.add(stu2);
        list.add(stu3);
        list.add(stu4);
        list.add(stu5);
        list.add(stu6);
        list.add(stu7);
        list.add(stu8);
        list.add(stu9);
        list.add(stu10);
        list.add(stu11);
        list.add(stu12);
        list.add(stu13);
        list.add(stu14);
        list.add(stu15);
        list.add(stu16);
        list.add(stu17);
        list.add(stu18);
        list.add(stu19);
        list.add(stu20);

        groupBySex(list);

    }

    // List<Student>按 age 从小到大 输出
    public static void sortByAge(List<Student> list){
        Collections.sort(list, new Comparator<Student>(){
            public int compare(Student stu1, Student stu2){
                return stu1.getAge() - stu2.getAge();
            }
        });
        for(Student stu : list){
            System.out.println(stu);
        }
    }

    // List<Student>按 score 从大到小 输出
    public static void sortByScore(List<Student> list){
        Collections.sort(list, new Comparator<Student>(){
            public int compare(Student stu1, Student stu2){
                return stu2.getScore() - stu1.getScore();
            }
        });
        for(Student stu : list){
            System.out.println(stu);
        }
    }

    // List<Student>按 name 首字母 从小到大 输出
    public static void sortByName(List<Student> list){
        Collections.sort(list, new Comparator<Student>(){
            public int compare(Student stu1, Student stu2){
                return stu1.getName().compareTo(stu2.getName());
            }
        });
        for(Student stu : list){
            System.out.println(stu);
        }
    }

    // List<Student> 分组 按sex分组，输出list1 list2
    public static void groupBySex(List<Student> list){
        List<Student> list1 = new java.util.ArrayList<Student>();
        List<Student> list2 = new java.util.ArrayList<Student>();
        for(Student stu : list){
            if(stu.getSex() == 1){
                list1.add(stu);
            }else{
                list2.add(stu);
            }
        }
        System.out.println("list1:");
        for(Student stu : list1){
            System.out.println(stu);
        }
        System.out.println("list2:");
        for(Student stu : list2){
            System.out.println(stu);
        }
    } 
    
}