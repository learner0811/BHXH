package ptit.insurance.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ptit.insurance.model.Account;
import ptit.insurance.model.User;
import ptit.insurance.service.CommonService;

@Controller
public class LoginCtr {
	@Autowired
	private CommonService commonService;
	
	@RequestMapping("/login")
	String login() {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView doLogin(@ModelAttribute Account acc, HttpSession session, RedirectAttributes redirect) {		
		ModelAndView mav = new ModelAndView();		
		acc = commonService.getAccount(acc.getUsername(), acc.getPassword());	
		
		if (acc != null) {
			User user = new User();			
			user = commonService.getUser(acc);
			user.setAccount(acc);			;
			session.setAttribute("user", user);
			session.setMaxInactiveInterval(60*15); 		//15min
			return new ModelAndView("redirect:/index");
		}
		mav.setViewName("redirect:/login");
		redirect.addFlashAttribute("errorMsg", "Tài khoản hoặc mật khẩu không đúng mời đăng nhập lại");
		return mav;
	}
	
	
}
