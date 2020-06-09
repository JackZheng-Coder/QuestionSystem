package com;

import com.dao.JdbcHelper;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * @ClassName:
 * @Description:
 * @author:
 * @date:
 * @Version:
 * @Copyright:
 */
public class Run {
    public static void main(String[] args) throws SQLException {
        System.out.println("---------------------------欢迎使用试题管理系统---------------------------");
        while (true){
            System.out.println("请选择操作(1.列出所有题目 2.按难度查询 3.添加试题 4.删除试题 5.退出系统): ");
            Scanner in= new Scanner(System.in);
            int num = in.nextInt(); //输入选项值
            switch (num){
                case 1:
                    //查询所有题目
                    JdbcHelper helper = new JdbcHelper();
                    helper.queryAllQuestion();
                    break;
                case 2: //按难度查询
                    JdbcHelper helper1 = new JdbcHelper();
                    System.out.print("请输入难度:");
                    int n = in.nextInt();
                    helper1.queryQuestionByDifficuty(n);
                    break;
                case 3://添加
                    boolean b = true;
                    boolean a = true;
                    JdbcHelper helper2 = new JdbcHelper();
                    System.out.println("请输入题目id:");
                    int id = in.nextInt();
                    a =  helper2.searchId(id);
                    if (a == false){
                        System.out.println("该id已经存在");
                        break;
                    }else {
                        System.out.println("请输入题目名:");
                        String name = in.next();
                        System.out.println("请输入题目备注或者题意:");
                        String beizhu = in.next();
                        System.out.println("请输入题目难度:");
                        int difficuty = in.nextInt();
                        b = helper2.addQuestons(id,name,beizhu,difficuty);
                        if (b == true){
                            System.out.println("添加成功");
                        }else
                            System.out.println("添加失败");
                        break;
                    }

                case 4://删除
                    boolean b1 = true;
                    JdbcHelper helper3 = new JdbcHelper();
                    System.out.print("请输入要删除的id:");
                    int id1 = in.nextInt();
                    b =  helper3.deleteQuestion(id1);
                    if (b == true){
                        System.out.println("删除成功");
                    }else
                        System.out.println("删除失败");
                    break;
                case 5:
                    //退出系统
                    System.out.println("谢谢使用，欢迎下次来...");
                    System.exit(0);
            }
        }
    }
}
