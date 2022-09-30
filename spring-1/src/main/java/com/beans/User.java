package com.beans;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : spring-1
 * @Package : com.beans
 * @createTime : 2022/9/30 10:23
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class User {

    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<String> select() throws SQLException {
        // datasource -> the location of database
        DataSource ds = new MysqlDataSource();
        ((MysqlDataSource) ds).setURL("jdbc:mysql://127.0.0.1:3306/test_7_12?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource) ds).setUser("root");
        ((MysqlDataSource) ds).setPassword("RLFrlf930Frank_wjq");

        // build connection
        Connection con = ds.getConnection();

        System.out.println(con);

        // do statement
        String sql = "SELECT classes.id,classes.name,count(student.id) as ci FROM student INNER JOIN classes ON student.classes_id = classes.id group by classes.id order by ci desc;";


        PreparedStatement statement = con.prepareStatement(sql);
//        statement.setInt();
//        Scanner sc = new Scanner(System.in);
//        for(int i =1;i<=4;i++){
//            statement.setString(i,sc.nextLine());
//        }
//        statement.setString(1,"student.id as si,student.name as sn");
//        System.out.println(statement);
        ResultSet rs = statement.executeQuery();
//        System.out.println(rs);
        List<String> list = new ArrayList<>();
        while (rs.next()) {
            int n = rs.getInt("id");
            String name = rs.getString(2);
            int m = rs.getInt("ci");
            list.add(n + ": " + name + ", num: " + m);
        }

        // close statement and connection
        try {
            if (rs != null) {
                rs.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("数据库错误");
        }
        return list;
    }
}
