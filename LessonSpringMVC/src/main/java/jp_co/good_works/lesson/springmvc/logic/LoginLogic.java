package jp_co.good_works.lesson.springmvc.logic;

import java.awt.desktop.SystemSleepListener;
import java.sql.SQLException;

import jp_co.good_works.lesson.springmvc.dao.UserDao;
import jp_co.good_works.lesson.springmvc.exception.LoginException;

public class LoginLogic {
	private LoginInfo loginInfo = null;
	public LoginInfo login(String userID,String password)throws LoginException{

		UserDao userDao = new UserDao();
		try {
			loginInfo =userDao.select(userID, password);
		
		if(loginInfo!=null){
			System.out.println("true");
		//String x= "guest";
		//String y= "guestguest";

		//if((userID.equals(x))&&(password.equals(y))) {
		//loginInfoのインスタンス化
				
		loginInfo =new LoginInfo(); 
		loginInfo.setUserId(userID);
		loginInfo.setPassword(password);
				 
		//}
			
		}else {

			System.out.println("false");
			throw new LoginException("ユーザIDまたはパスワードが違います");
		}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  loginInfo;
		}
	public boolean isLive () {

		if(loginInfo!=null) {
			//　ログイン成功
			return true;
		}else {
            //　ログイン失敗
			return false;
		}
	}
}
