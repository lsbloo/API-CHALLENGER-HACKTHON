package com.softapi.configuration;

import org.springframework.stereotype.Component;

import com.softapi.models.Privilege;
import com.softapi.models.Role;
import com.softapi.service.UserService;

import java.util.Arrays;
import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;


@Component
public class MyDataLoader  implements ApplicationListener<ContextRefreshedEvent>{

	
	private UserService userService;
	
	boolean s = false;
	
	
	@Autowired
	public MyDataLoader(UserService userService) {
		this.userService=userService;
	}
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		
		if (s) {
			return ;
		}
		
		
		Privilege privilege = createPrivilegeIfNotFound("READ_PRIVILEGE");
		Privilege privilege_write = createPrivilegeIfNotFound("WRITE_PRIVILEGE");
		
		Collection<Privilege> adminPrivileges = Arrays.asList(privilege,privilege_write);
		Role admin = createRoleIfNotFound("ROLE_ADMIN" , adminPrivileges);
		Role user = createRoleIfNotFound("ROLE_USER" , Arrays.asList(privilege));
		
		
		Role r = this.userService.getRoleByName("ROLE_ADMIN");

	}
	/**
	 * creates the roles of users for administrator and normal user being 
	 * the administrator access permission with read and write powers and the normal user only reading
	 * @param param_role
	 * @param collection
	 * @return
	 */
	@Transactional
	private Role createRoleIfNotFound(String param_role , Collection<Privilege> collection) {
		Role rol = this.userService.getRoleByName(param_role);
		if(rol == null) {
			Role r = new Role(param_role);
			r.setPrivileges(collection);
			this.userService.insertRoleEntity(r);
		}
		return rol;
	}
	@Transactional
	private Privilege createPrivilegeIfNotFound(String param_privilege) {
		Privilege p = this.userService.getPrivilegeByName(param_privilege);
		
		if(p == null) {
			Privilege priv = new Privilege(param_privilege);
			this.userService.insertPrivilegeEntity(priv);
		}
		return p;
	}
}
