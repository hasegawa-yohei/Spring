package jp_co.good_works.lesson.springmvc.controller.no_cert;

import java.sql.SQLException;



import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp_co.good_works.lesson.springmvc.exception.LoginException;
import jp_co.good_works.lesson.springmvc.form.LoginForm;
import jp_co.good_works.lesson.springmvc.logic.LoginLogic;

@Controller
@Scope("session")
public class LoginController {

	private LoginLogic loginLogic = new LoginLogic();

	public boolean isLive () {
		return loginLogic.isLive();
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String initializeLogin (Model model) {
		LoginForm form = new LoginForm();
		model.addAttribute("message","���͂��Ă�������");
		model.addAttribute("loginForm",form);
		return "login";	

	}

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String executeLogin(Model model,@Validated @ModelAttribute LoginForm form,
			//
			BindingResult result,RedirectAttributes redirectAttr) throws SQLException {
		//�o���f�[�V������if��
		if (!result.hasErrors()) {
			try {
				//
				loginLogic.login(form.getUserId(),form.getPassword());
				//hello.jsp�ɑJ�ځi�ȉ��̏����͍s���Ȃ��j
				return "redirect:/hello";
			} catch (LoginException e) {
				model.addAttribute("message", e.getLocalizedMessage());
			}
		}else {
			model.addAttribute("message", "���[�U ID �A �p�X���[�h����͂��Ă��������B");
		}
		return "login";
	}

}







