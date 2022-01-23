package com.sms.studentManageSystem.Service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.sms.studentManageSystem.Dto.UserRegistrationDto;
import com.sms.studentManageSystem.Entity.User;

public interface IUserService extends UserDetailsService {

	User save(UserRegistrationDto registrationDto);
	
}
