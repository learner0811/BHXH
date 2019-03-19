package ptit.insurance.controller;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ptit.insurance.model.User;
import ptit.insurance.service.CommonService;
import ptit.insurance.service.RegisterService;

@Controller
public class UserCtr {
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private RegisterService registerService;
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ModelAndView regisInfo(User user ,HttpSession session) {		
		Object userSession = session.getAttribute("user");				
		if (userSession == null)
			return new ModelAndView("redirect:/login");
		else
			user = (User) userSession;		
		ModelAndView mav = new ModelAndView();		
		mav.setViewName("user");
		mav.addObject("user", user);
		mav.addObject("cities", commonService.getAllCities());
		return mav;
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ModelAndView doRegisInfo(@ModelAttribute User user, RedirectAttributes redirct) {
		ModelAndView mav = new ModelAndView();					
		//validate 
		
		//insert to db
		registerService.updateInfo(user);		
		redirct.addFlashAttribute("successMsg", "Thay đổi thành công");
		mav.setViewName("redirect:/user");		
		return mav;
	}
}
