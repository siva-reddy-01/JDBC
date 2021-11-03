package Mysql;
import java.sql.*;
public class Create_Table
{
 public static void main(String args[])throws Exception
 {
  try
  {
   Connection con=null;
   Class.forName("com.mysql.cj.jdbc.Driver");
   System.out.println("Driver class loaded");
   con=DriverManager.getConnection("jdbc:mysql://localhost:3306/j","root","root");
   System.out.println("connection established");
   
   
   Statement stmt = con.createStatement();

   stmt.executeUpdate("create table employee(eid integer primary key,ename varchar(30) not null,salary decimal(10,4),gender varchar(20))");
   System.out.println("Table created");
  }
  catch(Exception e)
  {
   System.out.println(e);
  }
  
 }
}