package CodeSegment;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.naming.spi.DirStateFactory.Result;

public class DatabaseOperate {
    
    //  读取数据库 转化为 bean 对象 存储在 List 容器中
    public static List<Student> readDatabase(){
        List<Student> list = new ArrayList<Student>();
        try {
            //1.加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            //2.获得连接
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456");
            //3.创建Statement对象
            Statement stmt = (Statement) conn.createStatement();
            //4.执行SQL语句
            Result rs = (Result) ((java.sql.Statement) stmt).executeQuery("select * from student");
            //5.获得结果集对象
            while(((ResultSet) rs).next()){
                Student stu = new Student();
                stu.setName(((ResultSet) rs).getString("name"));
                stu.setAge(((ResultSet) rs).getInt("age"));
                stu.setScore(((ResultSet) rs).getInt("score"));
                stu.setSex(((ResultSet) rs).getInt("sex"));
                list.add(stu);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    //java 序列化对象 Student 
}
