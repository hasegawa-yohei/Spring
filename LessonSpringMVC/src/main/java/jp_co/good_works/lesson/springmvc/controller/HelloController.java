package jp_co.good_works.lesson.springmvc.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp_co.good_works.lesson.HomeController;
//　このファイルはコントローラーですよという宣言、今回はMVCモデルで作成しているので記載は必須
@Controller
public class HelloController {
	//@←アノテーション　valueのあとのURLに“/hello”があればhelloメソッドが実行
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello(Model model) {
		//jsp側に送られるもの　　　modelという箱のmessageのなかに　Hello,Spring!という文字列を格納
		model.addAttribute("message", "Hello,Spring!" );
		//hello.jspへ遷移
		return "hello";
	}
}
