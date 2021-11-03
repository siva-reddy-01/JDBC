package Demo;
import java.sql.*;
public class Create_Table
{
 public static void main(String args[])throws Exception
 {
  try
  {
   Connection con=null;
   Class.forName("oracle.jdbc.driver.OracleDriver");
   System.out.println("Driver class loaded");
   con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
   System.out.println("connection established");
   
   
   Statement stmt = con.createStatement();
   String qry="create table employee(eid integer primary key,ename varchar(30) not null,salary decimal(10,4),gender varchar(20))";
   stmt.executeUpdate(qry);
   System.out.println("Table created");
  }
  catch(Exception e)
  {
   System.out.println(e);
  }
  
 }
}