package org.jsp.jdbcaApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class jdbcpreparedstatment
{
public static void main(String[] args) 
{
	Connection con=null;
	PreparedStatement pstmt=null;
	String qry="insert into btm.student values(?,?,?)";
try {
	Class.forName("com.mysql.jdbc.Driver");
    System.out.println("class loaded");    
    con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
    pstmt=con.prepareStatement(qry);
    pstmt.setInt(1,101);
    pstmt.setString(2,"gayyu");
    pstmt.setDouble(3,98.34);
    pstmt.executeUpdate();
    
    pstmt.setInt(1,104);
    pstmt.setString(2,"patidar");
    pstmt.setDouble(3,94.4);
    pstmt.executeUpdate();
   
    System.out.println("record inserted");
    
    
}
    catch (ClassNotFoundException|SQLException  e)
    {
	e.printStackTrace();
    }
finally
{
   if(con!=null)
	try {
		con.close();
	} catch (SQLException e) 
    {
		e.printStackTrace();
	}
   if(pstmt!=null)
	try {
		pstmt.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
}
}
