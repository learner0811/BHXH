package ptit.insurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ptit.insurance.model.Account;
import ptit.insurance.model.Register;
import ptit.insurance.model.User;
import ptit.insurance.service.CommonService;
import ptit.insurance.service.RegisterService;

@Controller
public class RegisterCtr {
	@Autowired
	private RegisterService registerService;
	
	@Autowired
	private CommonService commonservice;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register() {
		ModelAndView mav = new ModelAndView();		
		mav.setViewName("register");
		return mav;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView doRegister(@ModelAttribute Register reg, RedirectAttributes redirect) {
		ModelAndView mav = new ModelAndView();				
		
		// validate password, confirm password and validate license
		if (!reg.getPassword().equals(reg.getConfirm_password())) {
			ModelAndView mavReg = new ModelAndView("redirect:/register");			
			redirect.addFlashAttribute("errorMsg", "Mật khẩu nhập lại không giống");
			return mavReg;
		}
		
		//validate if exsist user in system
		Integer accID = commonservice.checkUserNameExist(reg.getUsername());
		if (accID != null) {
			ModelAndView mavReg = new ModelAndView("redirect:/register");			
			redirect.addFlashAttribute("errorMsg", "Đã tồn tại tài khoản trong hệ thống");
			return mavReg;
		}
		
		//create object
		Account acc = new Account();
		acc.setUsername(reg.getUsername());
		acc.setPassword(reg.getPassword());
		acc.setEmail(reg.getEmail());		
		User user = new User();
		user.setAccount(acc);
		
		//insert to db
		try {
			registerService.Save(user);
		} catch (Exception ex) {
			System.out.println("Error when save user in register");
			ModelAndView mavReg = new ModelAndView("redirect:/register");			
			redirect.addFlashAttribute("errorMsg", "Có lỗi xảy ra trong quá trình đăng ký, mời thực hiện lại");
			return mavReg;
		}
		redirect.addFlashAttribute("successMsg", "Đăng ký thành công mời đăng nhập");
		mav.setViewName("redirect:/login");		
		return mav;
	}
}
