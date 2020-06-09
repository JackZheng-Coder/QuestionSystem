package com.dao;

import com.bean.Question;

import java.net.BindException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName:
 * @Description:
 * @author:
 * @date:
 * @Version:
 * @Copyright:
 */
public class JdbcHelper implements JdbcConfig{
    //定义连接数据库所需要的对象
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private Connection ct = null;

    //获得数据库的连接
    private void init(){
        try {
            Class.forName(DRIVER);
            ct = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    //初始化
    public JdbcHelper(){
        this.init();
    }

    //查询所有试题
    public void queryAllQuestion() throws SQLException {
        try {
            ps = ct.prepareStatement("select * from questionInfo"); //sql语句
            rs = ps.executeQuery();//查询结果到结果集
            while (rs.next()){
                int id = rs.getInt(1);// 获取第一个列的值
                String name = rs.getString(2); // 获取第二个列的值
                String beizhu = rs.getString(3);// 获取第三个列的值
                int difficuly = rs.getInt(4);// 获取第四个列的值
                System.out.println("题目id:"+id + "\t"+"题目名:" + name + "\t"+"备注:" + beizhu + "\t"+"难度:" + difficuly + "\t");
                System.out.println("................................................");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally { //资源关闭
            if (ps != null){
                ps.close();
            }
            if (rs != null) {
                rs.close();
            }
            if (ct != null){
                ct.close();
            }
        }
    }

    //按难度进行查询
    public void  queryQuestionByDifficuty(int diff) throws SQLException {
        try {
            ps = ct.prepareStatement("select * from questionInfo where question_difficuty=?" ); //查找难度值为x的信息
            ps.setInt(1,diff);//给参数赋值
            rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt(1);// 获取第一个列的值
                String name = rs.getString(2); // 获取第二个列的值
                String beizhu = rs.getString(3);
                int difficuly = rs.getInt(4);
                System.out.println("题目id:"+id + "\t"+"题目名:" + name + "\t"+"备注:" + beizhu + "\t"+"难度:" + difficuly + "\t");
                System.out.println("................................................");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (ps != null){
                ps.close();
            }
            if (rs != null) {
                rs.close();
            }
            if (ct != null){
                ct.close();
            }
        }
    }

    //增加题目
    public boolean addQuestons(int id,String name,String beizhu, int difficuty) throws SQLException {
        boolean b = true;
        try {
            ps = ct.prepareStatement("insert into questionInfo(question_id,question_name,question_beizhu,question_difficuty)values(?,?,?,?) ");
            ps.setInt(1,id);
            ps.setString(2,name);
            ps.setString(3,beizhu);
            ps.setInt(4,difficuty);
            if (ps.executeUpdate()!=1){
                b = false;
            }
        } catch (SQLException e) {
            b = false;
            e.printStackTrace();
        }finally {
            if (ps != null){
                ps.close();
            }
            if (ct != null){
                ct.close();
            }
        }
        return b;
    }

    //删除题目
    public boolean deleteQuestion(int id) throws SQLException {
        boolean b = true;
        try {
            ps = ct.prepareStatement("delete from questionInfo where question_id=?");
            ps.setInt(1,id);
            if (ps.executeUpdate() != 1){
                b = false;
            }
        } catch (SQLException e) {
            b = false;
            e.printStackTrace();
        }finally {
            if (ps != null){
                ps.close();
            }
            if (ct != null){
                ct.close();
            }
        }
        return b;
    }
    //添加题目时判断插入的id是否重复
    public boolean searchId(int id) throws SQLException {
        boolean a = true;
        try {
            ps = ct.prepareStatement("select id from questionInfo");
            rs = ps.executeQuery();
            ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.add(rs.getInt(1));
            for (int i = 0;i<arrayList.size();i++){
                if (id == arrayList.get(i)){
                     a = false;
                    break;
                }
            }
        } catch (SQLException e) {
             a = false;
            e.printStackTrace();
        }finally {
            if (ps != null){
                ps.close();
            }
            if (ct != null){
                ct.close();
            }
        }
        return a;
    }
}
