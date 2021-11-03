package Demo;
import java.sql.*;
public class Turncate_Table 
{

	public static void main(String[] args)throws Exception
	{
		try
		  {
		   Connection con=null;
		   Class.forName("oracle.jdbc.driver.OracleDriver");
		   System.out.println("Driver class loaded");
		   con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","jfsd","jfsd");
		   System.out.println("connection established");
		   
		   
		   Statement stmt = con.createStatement();
		   
		   String qry="truncate table employee";
		   stmt.execute(qry);
		   System.out.println("Turncated Table..");
		  }
		  catch(Exception e)
		  {
		   System.out.println(e);
		  }
	}

}
