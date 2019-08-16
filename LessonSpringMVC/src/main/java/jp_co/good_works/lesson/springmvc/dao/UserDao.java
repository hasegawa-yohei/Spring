package jp_co.good_works.lesson.springmvc.dao;

import java.awt.SystemTray;
import java.awt.peer.SystemTrayPeer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jp_co.good_works.lesson.springmvc.logic.LoginInfo;


public class UserDao {

	private static final String url = "jdbc:mysql://localhost/login?autoReconnect=true&useSSL=false";
	private static final String id = "root";
	private static final String pw = "password";
	//private static final String SQL =  "select * from user;";

	Connection cnct = null;
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement pst = null;

	public LoginInfo select(String userID,String password) throws SQLException{

		LoginInfo loginInfo = null;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			cnct= DriverManager.getConnection(url,id,pw);

			String quary = "select * from user where userid = ? and password = ?";
			pst = cnct.prepareStatement(quary);
			pst.setString(1,userID);
			pst.setString (2,password);
			rs = pst.executeQuery();

			if(rs.next()) {
				loginInfo = new LoginInfo();
				loginInfo.setUserId(userID);
				loginInfo.setPassword(password);

		    }
			
	}

	catch (ClassNotFoundException e) {
		e.printStackTrace();

	} catch (SQLException e) {
		e.printStackTrace();
	}


		return loginInfo;
		
}
}



