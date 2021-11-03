package Skill_2;


import java.sql.*;
import java.io.*;
import java.sql.PreparedStatement;
	
	@SuppressWarnings("unused")
	public class Retrive_image 
	{
	

		public static void main(String[] args)throws Exception
		{
			try
			{
				Connection con=null;
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Driver class loaded..");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/j","root","root");
				System.out.println("connection established..");
				
				String qry="select * from Students";
				PreparedStatement pstmt=con.prepareStatement(qry);
				ResultSet rs=pstmt.executeQuery();
				if(rs.next())
				{
				
					int id_number=rs.getInt(1);
					String first_name=rs.getString(2);
					String second_name=rs.getString(3);
					int year_of_study=rs.getInt(4);
					String department=rs.getString(5);
					String gender=rs.getString(6);
					String mobile_number=rs.getString(7);
					String date_of_birth=rs.getString(8);
					String parent_name=rs.getString(9);
					String parent_number=rs.getString(10);
					String address=rs.getString(11);
					String proof_image=rs.getString(12);
					String payment_recepit=rs.getString(13);
					
					System.out.println(""+id_number+"  "+first_name+"  "+second_name+"  "+year_of_study+"  "+department+"  "+gender+"  "+mobile_number+"  "+date_of_birth+"  "+parent_name+"  "+parent_number+"  "+address+" "+proof_image+","+payment_recepit+"");
				
					              

					
					
					
					

					              
				}
				
				
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}

	}

