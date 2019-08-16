package jp_co.good_works.lesson.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import jp_co.good_works.lesson.springmvc.form.UserInfoForm;


@Controller
//セッション
@Scope("session")
public class UserInfoController {
	//ユーザが入力した情報（名前、年齢、性別等全て）のリスト
  List<UserInfoForm> userInfoFormList = new ArrayList<UserInfoForm>();
	
  // 「/user」という名前でアクセスされたら以下の処理を行う
  @RequestMapping(value="/user", method = RequestMethod.GET)
	public String product(Model model) {
	  
	  //UserInfoFormのインスタンス化（材料）
		UserInfoForm form = new UserInfoForm();
	  //性別、出身地、好きな言語の選択肢のリスト（JSP出力時の）
		List<String> genders = new ArrayList<String>();
		List<String> birthplaces = new ArrayList<String>();
		List<String> favoriteLangs = new ArrayList<String>();
		
	 //userInfoFormListを同名で追加する
		model.addAttribute("userInfoFormList",userInfoFormList);
		
	 //各選択肢の設定
		genders.add("男");
		genders.add("女");
		model.addAttribute("genders",genders);
		
		favoriteLangs.add("Java");
		favoriteLangs.add("C#");
		favoriteLangs.add("C/C++");
		favoriteLangs.add("PHP");
		favoriteLangs.add("Perl");
		favoriteLangs.add("Ruby");
		favoriteLangs.add("Python");
		model.addAttribute("favoriteLangs",favoriteLangs);

		birthplaces.add("");
		birthplaces.add("北海道");
		birthplaces.add("東北");
		birthplaces.add("関東");
		birthplaces.add("中部");
		birthplaces.add("近畿");
		birthplaces.add("中国");
		birthplaces.add("四国");
		birthplaces.add("九州");
		model.addAttribute("birthplaces",birthplaces);
	
	    //messageに文言を追加
		model.addAttribute("message","ユーザ情報を入力してください");
		//userInfoFormにformオブジェクトを格納（器づくり）
		model.addAttribute("userInfoForm",form);
		//遷移先のJSP
		return "userinfo";	
	}
  
   
	@RequestMapping(value ="/user", method = RequestMethod.POST)
	//送信ボタンが押されたら呼ばれる　　　　　　　　　　　　　　　　　　　　↓JSPから受け取るオブジェクト（入力内容の情報）　
	public String product(Model model,@Validated @ModelAttribute UserInfoForm form , BindingResult result) {
		
		List<String> genders = new ArrayList<String>();
		List<String> birthplaces = new ArrayList<String>();
		List<String> favoriteLangs = new ArrayList<String>();
		
		genders.add("男");
		genders.add("女");
		model.addAttribute("genders",genders);

		favoriteLangs.add("Java");
		favoriteLangs.add("C#");
		favoriteLangs.add("C/C++");
		favoriteLangs.add("PHP");
		favoriteLangs.add("Perl");
		favoriteLangs.add("Ruby");
		favoriteLangs.add("Python");
		model.addAttribute("favoriteLangs",favoriteLangs);

		birthplaces.add("");
		birthplaces.add("北海道");
		birthplaces.add("東北");
		birthplaces.add("関東");
		birthplaces.add("中部");
		birthplaces.add("近畿");
		birthplaces.add("中国");
		birthplaces.add("四国");
		birthplaces.add("九州");
		model.addAttribute("birthplaces",birthplaces);
		
		if(result.hasErrors()) {
			model.addAttribute("message","エラーがあります");
		}else {
		model.addAttribute("message" , "ユーザ情報が入力されました");
		//入力内容全部の追加
		userInfoFormList.add(form);
		}
		model.addAttribute("userInfoForm",form);
		model.addAttribute("userInfoFormList",userInfoFormList);
		return "userinfo";

	}
}