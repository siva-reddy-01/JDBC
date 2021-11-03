package Demo;
import java.sql.*;

public class Alter_Table {

	public static void main(String[] args)throws Exception
	{
		// TODO Auto-generated method stub
		try
		{
			Connection con=null;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver class loaded..");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","jfsd","jfsd");
			System.out.println("connetion established..");
			
			Statement stmt=con.createStatement();
			String qry =  " alter table employee add(dept varchar(20) default'CSE')";
			stmt.executeUpdate(qry);
			System.out.println("Alter the table....");
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}

}
