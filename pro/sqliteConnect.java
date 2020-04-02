package pro;

import java.sql.*;


import javax.swing.*;
public class sqliteConnect {
	Connection conn=null;
		public static Connection dbConnector()
		{
			try {
				Class.forName("org.sqlite.JDBC");
				Connection conn=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\NIKITA\\Downloads\\bus.sqlite");
				//JOptionPane.showMessageDialog(null, "Connection Success");
				return conn;
			}catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, e);
				return null;
			}
		}
}