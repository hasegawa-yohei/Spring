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
//�Z�b�V����
@Scope("session")
public class UserInfoController {
	//���[�U�����͂������i���O�A�N��A���ʓ��S�āj�̃��X�g
  List<UserInfoForm> userInfoFormList = new ArrayList<UserInfoForm>();
	
  // �u/user�v�Ƃ������O�ŃA�N�Z�X���ꂽ��ȉ��̏������s��
  @RequestMapping(value="/user", method = RequestMethod.GET)
	public String product(Model model) {
	  
	  //UserInfoForm�̃C���X�^���X���i�ޗ��j
		UserInfoForm form = new UserInfoForm();
	  //���ʁA�o�g�n�A�D���Ȍ���̑I�����̃��X�g�iJSP�o�͎��́j
		List<String> genders = new ArrayList<String>();
		List<String> birthplaces = new ArrayList<String>();
		List<String> favoriteLangs = new ArrayList<String>();
		
	 //userInfoFormList�𓯖��Œǉ�����
		model.addAttribute("userInfoFormList",userInfoFormList);
		
	 //�e�I�����̐ݒ�
		genders.add("�j");
		genders.add("��");
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
		birthplaces.add("�k�C��");
		birthplaces.add("���k");
		birthplaces.add("�֓�");
		birthplaces.add("����");
		birthplaces.add("�ߋE");
		birthplaces.add("����");
		birthplaces.add("�l��");
		birthplaces.add("��B");
		model.addAttribute("birthplaces",birthplaces);
	
	    //message�ɕ�����ǉ�
		model.addAttribute("message","���[�U������͂��Ă�������");
		//userInfoForm��form�I�u�W�F�N�g���i�[�i��Â���j
		model.addAttribute("userInfoForm",form);
		//�J�ڐ��JSP
		return "userinfo";	
	}
  
   
	@RequestMapping(value ="/user", method = RequestMethod.POST)
	//���M�{�^���������ꂽ��Ă΂��@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@��JSP����󂯎��I�u�W�F�N�g�i���͓��e�̏��j�@
	public String product(Model model,@Validated @ModelAttribute UserInfoForm form , BindingResult result) {
		
		List<String> genders = new ArrayList<String>();
		List<String> birthplaces = new ArrayList<String>();
		List<String> favoriteLangs = new ArrayList<String>();
		
		genders.add("�j");
		genders.add("��");
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
		birthplaces.add("�k�C��");
		birthplaces.add("���k");
		birthplaces.add("�֓�");
		birthplaces.add("����");
		birthplaces.add("�ߋE");
		birthplaces.add("����");
		birthplaces.add("�l��");
		birthplaces.add("��B");
		model.addAttribute("birthplaces",birthplaces);
		
		if(result.hasErrors()) {
			model.addAttribute("message","�G���[������܂�");
		}else {
		model.addAttribute("message" , "���[�U��񂪓��͂���܂���");
		//���͓��e�S���̒ǉ�
		userInfoFormList.add(form);
		}
		model.addAttribute("userInfoForm",form);
		model.addAttribute("userInfoFormList",userInfoFormList);
		return "userinfo";

	}
}