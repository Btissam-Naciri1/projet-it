package com.example.Controller.DAO;


import com.example.Controller.MODEL.Employe;

import java.util.*;
import java.sql.*;

public class EmployeeDao {

    public static Connection getConnection(){
        Connection con=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","");
        }catch(Exception e){System.out.println(e);}
        return con;
    }
    public static int affecter(Employe e){
        int status=0;
        try{
            Connection con=EmployeeDao.getConnection();
            PreparedStatement ps=con.prepareStatement(
                    "insert into employees(name,password,email,country) values (?,?,?,?)");
            ps.setString(1,e.getName());
            ps.setLong(2,e.getId());
            ps.setString(3,e.getEmail());
            String skillsAsString = String.join(",", Employe.getSkills());
            ps.setString(4, skillsAsString);

            status=ps.executeUpdate();

            con.close();
        }catch(Exception ex){ex.printStackTrace();}

        return status;
    }

    public static int delete(int id){
        int status=0;
        try{
            Connection con=EmployeeDao.getConnection();
            PreparedStatement ps=con.prepareStatement("delete from user905 where id=?");
            ps.setInt(1,id);
            status=ps.executeUpdate();

            con.close();
        }catch(Exception e){e.printStackTrace();}

        return status;
    }

    public static List<Employe> getAllEmployees(){
        List<Employe> list=new ArrayList<Employe>();

        try{
            Connection con=EmployeeDao.getConnection();
            PreparedStatement ps=con.prepareStatement("select * from user905");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Employe e=new Employe();
                e.setId(rs.getLong(1));
                e.setName(rs.getString(2));
                e.setEmail(rs.getString(3));
                e.setSkills(rs.getString(5));
                list.add(e);
            }
            con.close();
        }catch(Exception e){e.printStackTrace();}

        return list;
    }
}
