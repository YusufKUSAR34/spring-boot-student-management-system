package com.sms.studentManageSystem.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sms.studentManageSystem.Dto.UserRegistrationDto;
import com.sms.studentManageSystem.Service.IUserService;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

	private IUserService userService;

	public UserRegistrationController(IUserService userService) {

		this.userService = userService;
	}
	
	@ModelAttribute("user")
	public UserRegistrationDto userRegistrationDto()
	{
		return  new UserRegistrationDto();
	}
	
	@GetMapping
	public String showRegistrationForm() {
		//model.addAttribute("user",new UserRegistrationDto());
		return "registration";
	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto userRegistrationDto)
	{
		userService.save(userRegistrationDto);
		return "redirect:/registration?success";
	}
	
}
