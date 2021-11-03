package PreparedStatements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Drop_Table {

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
			
			
			String qry="drop table student";
			PreparedStatement pstmt=con.prepareStatement(qry);
			pstmt.execute();
			System.out.println("Table is dropped...");
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}

}
