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
//�@���̃t�@�C���̓R���g���[���[�ł���Ƃ����錾�A�����MVC���f���ō쐬���Ă���̂ŋL�ڂ͕K�{
@Controller
public class HelloController {
	//@���A�m�e�[�V�����@value�̂��Ƃ�URL�Ɂg/hello�h�������hello���\�b�h�����s
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello(Model model) {
		//jsp���ɑ�������́@�@�@model�Ƃ�������message�̂Ȃ��Ɂ@Hello,Spring!�Ƃ�����������i�[
		model.addAttribute("message", "Hello,Spring!" );
		//hello.jsp�֑J��
		return "hello";
	}
}
