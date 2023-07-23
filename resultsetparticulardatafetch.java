package org.jsp.jdbcaApp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class resultsetparticulardatafetch 
{
 public static void main(String[] args) 
 {
	   Scanner sc=new Scanner(System.in);
	   System.out.println("enter name which data you want to fetch");
	   String name=sc.nextLine();
	    Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String qry="Select * from btm.student where name=?";
		
	  try {
		  Class.forName("com.mysql.jdbc.Driver");
		  con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
		   pstmt=con.prepareStatement(qry);
		   pstmt.setString(1,name);
		   rs=pstmt.executeQuery();
		   if(rs.next())
		   {
			  int id=rs.getInt(1);
			  double per=rs.getDouble(3);
			  
			  System.out.println("id="+id);
			  System.out.println("percentage="+per);
		  }
		   else
		   {
			   System.out.println("no data found for name"+name);
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
			} catch (SQLException e)
			{
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


