package com.sms.studentManageSystem.Service.Impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sms.studentManageSystem.Dto.UserRegistrationDto;
import com.sms.studentManageSystem.Entity.Role;
import com.sms.studentManageSystem.Entity.User;
import com.sms.studentManageSystem.Repository.IUserRepository;
import com.sms.studentManageSystem.Service.IUserService;

@Service
public class UserServiceImpl  implements IUserService{

	
	private IUserRepository userRepository;
	
	
	@Autowired
	private  BCryptPasswordEncoder passwordEncoder;
	
	
	public UserServiceImpl( IUserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}


	@Override
	public User save(UserRegistrationDto registrationDto) {
		User user = new User(registrationDto.getFirstName(), 
				registrationDto.getLastName(), registrationDto.getEmail(),
				passwordEncoder.encode(registrationDto.getPassword()), Arrays.asList(new Role("ROLE_USER")));
		
		return userRepository.save(user);
	
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		  User user=  userRepository.findByEmail(username);
		  if(user==null)
		  {
			    throw new UsernameNotFoundException("Kullanıcı Adı ya da şifre geçersiz");
		  }
		return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),mapRolesToAuthorities(user.getRoles()));
	}
	
	private  Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles)
	{
		return  roles.stream().map(role->new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	
	}

}
