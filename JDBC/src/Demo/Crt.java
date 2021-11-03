package Demo;

import java.sql.*;


import java.util.Scanner; 
public class Crt{
  public static void main(String[] args) throws Exception {        
        Statement statement = null; 
        Scanner scanner = null;
        Class.forName("com.mysql.cj.jdbc.Driver");  
    Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/jfsd","root","root");       
        try { 
          int studentNo=0;
          int b=0;
          float c=0;
          int u=0;
          int org=0;
          String test=null;
            scanner = new Scanner(System.in); 
            System.out.println("are you instructed to update their backlogs and CGPA "); 
            String t=scanner.next();
            statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,  
                    ResultSet.CONCUR_UPDATABLE);
            while(t.startsWith("no")) {
                System.out.println("ok");
              break;
            }
          
            while(!t.startsWith("no")){
           
                System.out.println("Enter Student No"); 
                studentNo = scanner.nextInt();            
        ResultSet rs = statement.executeQuery("SELECT no_of_baglogs,cgpa,student_name from student_details where student_id_number="+studentNo);
         
        rs.absolute(1);
         System.out.println("number of backlogs cleared by "+rs.getString(3)+" are"); 
                org=rs.getInt(1);
        b=scanner.nextInt();
        u=org-b;
        if(u>=0) {
        statement.executeUpdate("update student_details"+" set no_of_baglogs="+u+" where student_id_number="+studentNo);
        }
         System.out.println("enter his updated cgpa "); 
              c=scanner.nextFloat();
          statement.executeUpdate("update student_details"+" set cgpa="+c+" where student_id_number="+studentNo);
          System.out.println("enter the cgpa need for crt ");
          
          float cg=scanner.nextFloat();
          boolean bb=true;
          ResultSet rs1;
          do {
          rs1 = statement.executeQuery("select cgpa from student_details");
          ResultSetMetaData rsmd = rs1.getMetaData();
          int col = rsmd.getColumnCount();
          System.out.println("deleting the students who got less than"+cg);
          
          for(int i=1; i <=col; i++){
          rs1.absolute(1);
            if(rs1.getFloat(i)<cg)
             {  
            statement.executeUpdate("delete  from student_details where cgpa="+rs1.getFloat(1));  
             }
           }
          
          
          bb=false;
          }while(bb);
          Statement sta = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,  
                        ResultSet.CONCUR_UPDATABLE);
      
          System.out.println("these students are eligible to crt");
          @SuppressWarnings("null")
        ResultSet rs2=sta.executeQuery("select student_name from student_details");
          while (rs2.next()) {
              System.out.println(rs2.getString(1)); //gets the first column's rows.
          }
          System.out.println();
          
          System.out.println("do you need to change any other student backlogs or cgpa."); 
          System.out.println("enter 'yes' to continue or 'no' to stop");
              test=scanner.next();
             
              if(test.startsWith("no")) {
                System.out.println("thanks for updating...");
              break;
                 }
              else {
                continue;
              }
            }         
        }           
        catch (Exception e) { 
            e.printStackTrace(); 
        } finally { 
            try { 
                if (statement != null) { 
                    statement.close(); 
                } 
            } catch (SQLException sqe) { 
                sqe.printStackTrace(); 
            } 
        } 
    }

}