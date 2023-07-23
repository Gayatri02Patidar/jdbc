package org.jsp.jdbcaApp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class jdbcresultset
{
public static void main(String[] args) 
{
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String qry="Select * from btm.student";
  try {
	  Class.forName("com.mysql.jdbc.Driver");
	  con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
	   pstmt=con.prepareStatement(qry);
	   rs=pstmt.executeQuery();
	   while(rs.next())
	   {
		  int id=rs.getInt(1);
		  String name=rs.getString(2);
		  Double per=rs.getDouble(3);  
		  System.out.println("id="+id);
		  System.out.println("name="+name);
		  System.out.println("percentage="+per);
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
