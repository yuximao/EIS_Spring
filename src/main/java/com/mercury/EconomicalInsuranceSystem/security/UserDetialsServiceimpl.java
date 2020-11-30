package com.mercury.EconomicalInsuranceSystem.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mercury.EconomicalInsuranceSystem.beans.User;
import com.mercury.EconomicalInsuranceSystem.daos.UserDao;


@Service	//变成bean
public class UserDetialsServiceimpl implements UserDetailsService {
	@Autowired
	private UserDao userdao;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		//给我username，拿回数据库里的username。找不到就会扔exception
		 System.out.println(username);
		 User user= userdao.findByUsername(username);
		 if(user==null){
			 throw new UsernameNotFoundException(username+"not find!!");
		 }
		 return user;
	}

}
