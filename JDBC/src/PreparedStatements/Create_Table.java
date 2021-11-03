package PreparedStatements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class Create_Table
{
 public static void main(String args[])throws Exception
 {
  try
  {
   Connection con=null;
   Class.forName("oracle.jdbc.driver.OracleDriver");
   System.out.println("Driver class loaded");
   con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","jfsd","jfsd");
   System.out.println("connection established");
   
   
  

   String qry="create table student(sid integer primary key,sname varchar(30) not null,salary decimal(10,4),gender varchar(20))";
   PreparedStatement pstmt=con.prepareStatement(qry);
   pstmt.execute();
   System.out.println("Table created");
  }
  catch(Exception e)
  {
   System.out.println(e);
  }
  
 }
}
