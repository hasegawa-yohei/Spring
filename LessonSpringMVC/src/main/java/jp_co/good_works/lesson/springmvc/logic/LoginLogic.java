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
		//loginInfo�̃C���X�^���X��
				
		loginInfo =new LoginInfo(); 
		loginInfo.setUserId(userID);
		loginInfo.setPassword(password);
				 
		//}
			
		}else {

			System.out.println("false");
			throw new LoginException("���[�UID�܂��̓p�X���[�h���Ⴂ�܂�");
		}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  loginInfo;
		}
	public boolean isLive () {

		if(loginInfo!=null) {
			//�@���O�C������
			return true;
		}else {
            //�@���O�C�����s
			return false;
		}
	}
}
