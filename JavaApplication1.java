/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication1;
import java.sql.*;

/**
 *
 * @author aripa
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        int i,j;
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","manoj","manoj");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from demo");
			while(rs.next())  {
				i = rs.getInt(1);j = rs.getInt(2);//rs.getInt(3));
                                System.out.println(i+" "+j);
                        }
                    //    stmt.executeUpdate("INSERT INTO AIRPORTS VALUES(17.2405,78.4294,'Rajiv Gandhi International Airport','India','RGIA')");
                        con.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

    
}
