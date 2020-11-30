package com.mercury.EconomicalInsuranceSystem.services;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mercury.EconomicalInsuranceSystem.beans.Role;
import com.mercury.EconomicalInsuranceSystem.beans.User;
import com.mercury.EconomicalInsuranceSystem.daos.UserDao;
import com.mercury.EconomicalInsuranceSystem.http.Response;

@Service
public class UserService {

	@Autowired
	private UserDao userdao;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public List<User> getAll(){
		return userdao.findAll();
	}
	
	public User getById(int id){

		return userdao.findById(id).get();
	}

	public Response deleteUser(int id){
		if(userdao.findById(id).get() != null) {
			userdao.deleteById(id);
			return new Response(true);
		}else {
			return new Response(false, "User is not found!");
		}
	}
	
	public Response register(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		Role role = new Role(1,"user");
		user.setRole(role);
		userdao.save(user); 
		
		return new Response(true);
	}
	
	public Response updateUser(User user){
		User u= userdao.findById(user.getId()).get();
		u.setUsername(user.getUsername());
		u.setEmail(user.getEmail());
		if(user.getPassword() != null){
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			u.setPassword(user.getPassword());
		}
		userdao.save(u);
		return new Response(true);
	}
	
	public Response changePassword(User user, Authentication authentication) {
		if(user.getUsername().equals(authentication.getName()) || isAdmin(authentication.getAuthorities())) {
			User u = userdao.findByUsername(user.getUsername());
			u.setPassword(passwordEncoder.encode(user.getPassword()));
			userdao.save(u);
		}else {
			//TODO: Not authorize to update password if not current loggedin user or admin.
			return new Response(false);
		}
		return new Response(true);
	}
	public boolean isAdmin(Collection<? extends GrantedAuthority> roles) {
		boolean isAdmin = false;
		for(GrantedAuthority role: roles) {
			if(role.getAuthority().equals("admin")) {
				isAdmin = true;
			}
		};
		return isAdmin;
	}
	
}
