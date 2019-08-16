package jp_co.good_works.lesson.springmvc.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import
org.springframework.web.servlet.support.WebContentGenerator;

import jp_co.good_works.lesson.springmvc.controller.no_cert.LoginController;
@Aspect
@Component
public class CertificateComponent extends WebContentGenerator{
	
	//　指定したディレクトリ配下のコントローラーにAOPを適用させる
	@Around("execution(* jp_co.good_works.lesson.springmvc.controller.*.*(..))")
	public String checkAuthenticated (ProceedingJoinPoint joinPoint ) throws Throwable{
		
		//　ログインコントローラーをAOPとして指定している（クラスファイルを指定しなければならない）
		//　　インスタンス化
	LoginController loginController = getApplicationContext().getBean(LoginController.class);
	if(loginController.isLive()) {
		//　指定したcontrollerに遷移する
		return (String) joinPoint.proceed(); 
	}
	//login.jspに遷移する
	return"redirect:/login";
}
}

