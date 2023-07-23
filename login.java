package org.jsp.jdbcaApp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class login 
{
 public static void main(String[] args) 
 {
	   Scanner sc=new Scanner(System.in);
	   System.out.println("enter name");
	   String name=sc.nextLine();
	   System.out.println("enter password");
	   String password=sc.nextLine();
	   
	    Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String qry="Select name from btm.user where name=? and password=?";
		
		
	  try {
		  Class.forName("com.mysql.jdbc.Driver");
		  con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
		   pstmt=con.prepareStatement(qry);
		   pstmt.setString(1,name);
		   pstmt.setString(2,password);
			   
		   rs=pstmt.executeQuery();
		   if(rs.next())
		   {
			  String un=rs.getString(1);
			  
			  
			  System.out.println("Welcome"+un);
			  
		  }
		   else
		   {
			   System.out.println("invalid name or password");
		   }
	} catch (ClassNotFoundException|SQLException e)
	  {
		e.printStackTrace();
	  }	
	  finally
	  {
		  if(rs!=null)
		  {
			  try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		  }
		  if(pstmt!=null)
		  {
			  try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		  }
		  if(con!=null)
		  {
			  try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		  }
	  }


}
	

}


