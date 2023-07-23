package org.jsp.jdbcaApp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class jdbcDemo 
{
public static void main(String[] args) 
{
	Connection con=null;
	Statement st=null;
	String qry="insert into btm.student values(1,'gayatri',89.33)";

 try
 {
	Class.forName("com.mysql.jdbc.Driver");
	System.out.println("class loaded");
    con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
	System.out.println("connection establish");
    st=con.createStatement();
    System.out.println("statement created");
    st.executeUpdate(qry);
    System.out.println("excute query");
 }
 catch (ClassNotFoundException|SQLException e)
 {
	e.printStackTrace();
 }
 finally
 {
	 if(st!=null)
	 {
		 
			 try {
				st.close();
			}
			 catch (SQLException e)
			 {
				e.printStackTrace();
			}
	 }
	 if(con!=null)
	 {
		 try {
			con.close();
		} catch (SQLException e)
		 {
			e.printStackTrace();
		}
	 }
 }
}
}
