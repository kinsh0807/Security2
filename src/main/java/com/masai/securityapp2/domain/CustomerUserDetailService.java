package com.masai.securityapp2.domain;

import com.masai.securityapp2.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerUserDetailService implements UserDetailsService{

	@Autowired
	private EmployeeRepo empRepo;
	CustomUser user = null;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Employee emp = empRepo.findByUserName(username);
		
		if(emp!=null) {
			user = new CustomUser(emp);
		}
		
		return user;
	}

}
