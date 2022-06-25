package CodeSegment;

public class Student {
    // 学生类
    private String name;
    private int age;
    private int score;
    private int sex;

    public Student(String name, int age, int score) {
        new Student(name, age, score, 1);
    }

    public Student(String name, int age, int score, int sex) {
        this.name = name;
        this.age = age;
        this.score = score;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getScore() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String toString() {
        return "姓名：" + name + "，年龄：" + age + "，成绩：" + score + ", 性别：" + sex;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Student) {
            Student stu = (Student) obj;
            if (this.name.equals(stu.getName()) && this.age == stu.getAge() && this.score == stu.getScore()
                    && this.sex == stu.getSex()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.name.hashCode() + this.age + this.score + this.sex;
    }

    public static void main(String[] args) {
        Student stu1 = new Student("张三", 20, 100,1);
        Student stu2 = new Student("张三", 20, 200,0);
        System.out.println(stu1.equals(stu2));
        System.out.println(stu1.hashCode());
        System.out.println(stu2.hashCode());
    }

}