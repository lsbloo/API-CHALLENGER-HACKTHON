package com.softapi.configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.softapi.models.Role;
import com.softapi.models.User;
import com.softapi.repository.RoleRepository;
import com.softapi.repository.UserRepository;

/**
 * DETAILL SERVICE IMPL;
 * @author osvaldoairon
 *
 */
@Service
@Transactional
public class UserDetailService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User u = this.userRepository.checkIfUserExist(username);
		//Integer role_id = this.roleRepository.findRoleIdByUserId(String.valueOf(u.getId()));
		//Role r = this.roleRepository.findRoleById(String.valueOf(role_id));
		
		if(u!= null) {
			
			return new org.springframework.security.core.userdetails.User(
					
			          u.getUsername(), u.getPassword(), u.isActivated(), true, true, 
			          true, getAuthorities(u.getRoles(),u.getId()));
		}
		else {
			return null;
		}
		
	}
	

	private Collection<? extends GrantedAuthority> getAuthorities(
	      Collection<Role> roles , Long id) {
	        return getGrantedAuthorities(roles,id);
	    }
	    private List<GrantedAuthority> getGrantedAuthorities(Collection<Role> roles , Long id) {
	        List<GrantedAuthority> authorities = new ArrayList<>();
	        //Integer id_r = this.userService.getRoleIdByUserId(id);
	        //String role = this.userService.getRoleById(role_id);
	        for (Role privilege : roles) {
	            authorities.add(new SimpleGrantedAuthority(privilege.getAuthority()));
	        }
	        return authorities;
	    }
	    
	    
	    private List<String> getPrivileges(Collection<Role> roles) {
	        List<String> privileges = new ArrayList<>();
	        List<String> collection = new ArrayList<>();
	        for (Role role : roles) {
	            collection.add(role.getAuthority());
	        }
	        if(collection!=null) {
	        	for(int i =0 ; i<collection.size();i++) {
	        		System.err.println(privileges.get(i));
	        		privileges.add(collection.get(i));
	        	}
	        }
	        return privileges;
	        
	    }
	
	

}
