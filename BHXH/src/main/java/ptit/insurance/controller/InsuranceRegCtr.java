package ptit.insurance.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ptit.insurance.model.Insurance;
import ptit.insurance.model.InsuranceReg;
import ptit.insurance.model.User;
import ptit.insurance.service.CommonService;
import ptit.insurance.service.InsuranceService;

@Controller
public class InsuranceRegCtr {
	@Autowired
	private InsuranceService insuranceService;
	
	@Autowired
	private CommonService commonService;
	
	@RequestMapping(value = "/insurancereg", method = RequestMethod.GET)
	public ModelAndView regisInfo(User user, HttpSession session) {
		Object userSession = session.getAttribute("user");
		if (userSession == null)
			return new ModelAndView("redirect:/login");
		user = (User) userSession;
		
		/*Integer insuranceId = commonService.getInsuranceId(user.getId());
		System.out.println("insurance id is " + insuranceId);
		if (insuranceId == null)
			return new ModelAndView("redirect:/user");*/
		ModelAndView mav = new ModelAndView();
		mav.setViewName("insuranceReg");
		return mav;
	}

	@RequestMapping(value = "/insurancereg", method = RequestMethod.POST)
	public ModelAndView doRegisInfo(@ModelAttribute InsuranceReg reg, User user, HttpSession session, RedirectAttributes redirect) {
		Object userSession = session.getAttribute("user");
		if (userSession == null)
			return new ModelAndView("redirect:/login");
		user = (User) userSession;

		// validate
		int income = Integer.parseInt(reg.getIncome());
		if (income < 2000000) {
			redirect.addFlashAttribute("errorMsg", "Thu nhập dưới 2 triệu không thể đăng ký bảo hiểm");
			return new ModelAndView("redirect:/insurancereg");
		}
				
		/*if (commonService.checkUserInsuranceExist(user.getId()) != null) {
			redirect.addFlashAttribute("errorMsg", "Đã tồn tại bảo hiểm cho");
			return new ModelAndView("redirect:/insurancereg");
		}*/
		
		// insert to db
		Insurance insurance = new Insurance();
		insurance.setType(reg.getInsuranceType());
		insurance.setTaxcode(reg.getTaxCode());
		insurance.setStatus(1);
		insurance.setStartDate(new Date());
		insurance.setIncome(reg.getIncome());
		user.setInsurance(insurance);
		insuranceService.save(user);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("insuranceReg");
		return mav;
	}
}
