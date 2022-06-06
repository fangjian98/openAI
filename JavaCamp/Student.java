class Student{
    //学生类
    private String name;
    private int age;
    private int score;
    public Student(String name, int age, int score){
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public int getScore(){
        return score;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setScore(int score){
        this.score = score;
    }

    public String toString(){
        return "姓名：" + name + "，年龄：" + age + "，成绩：" + score;
    }

    public boolean equals(Object obj){
        if(obj instanceof Student){
            Student stu = (Student)obj;
            if(this.name.equals(stu.getName()) && this.age == stu.getAge() && this.score == stu.getScore()){
                return true;
            }
        }
        return false;
    }

    public int hashCode(){
        return this.name.hashCode() + this.age + this.score;
    }

    public static void main(String[] args){
        Student stu1 = new Student("张三", 20, 100);
        Student stu2 = new Student("张三", 20, 200);
        System.out.println(stu1.equals(stu2));
        System.out.println(stu1.hashCode());
        System.out.println(stu2.hashCode());
    }

}