package com.softapi.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.softapi.models.Consumer;
import com.softapi.models.Privilege;
import com.softapi.models.Role;
import com.softapi.models.Shopkeeper;
import com.softapi.repository.ConsumerRepository;
import com.softapi.repository.ShopKeeperRepository;
import com.softapi.repository.UserRepository;
import com.softapi.validator.ServiceValidator;
import com.softapi.repository.EnderecoRepository;
import com.softapi.repository.PrivilegeRepository;
import com.softapi.repository.RoleRepository;

@Service
public class UserService {
	
	protected static final String USER="ROLE_USER";
	
	private ShopKeeperRepository shopKrepository;
	private  UserRepository userRepository;
	private ConsumerRepository consumerRepository;
	private ServiceValidator serviceValidator;
	private EnderecoRepository enderecoRepository;
	private RoleRepository roleRepository;
	private PrivilegeRepository privilegeRepository;
	
	
	
	@Autowired
	public UserService (UserRepository userRepository,ShopKeeperRepository keeper, ConsumerRepository consumerRepository
			,EnderecoRepository enderecoRepository, RoleRepository roleRepository, PrivilegeRepository privilegeRepository) {
		this.userRepository=userRepository;
		this.shopKrepository=keeper;
		this.consumerRepository=consumerRepository;
		this.serviceValidator=new ServiceValidator(this.userRepository);
		this.enderecoRepository=enderecoRepository;
		this.privilegeRepository=privilegeRepository;
		this.roleRepository=roleRepository;
		
	}
	
	
	/**
	 * Insert new Object Privilege;
	 * @param privilege
	 */
	public void insertPrivilegeEntity(Privilege privilege) {
		this.privilegeRepository.save(privilege);
	}
	
	
	
	public Privilege getPrivilegeByName(String name) {
		return this.privilegeRepository.getPrivilegeByName(name);
	}
	
	/**
	 * return role object by search name;
	 * @param name
	 * @return
	 */
	public Role getRoleByName(String name) {
		return this.roleRepository.findRoleByNameParam(name);
	}
	
	/**
	 * Insert new Object Privilege;
	 * @param
	 */
	public void insertRoleEntity(Role role) {
		this.roleRepository.save(role);
	}
	

	
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	public boolean createConsumer(Consumer consumer) {
		if (consumer != null) {
		
			if (!this.serviceValidator.checkExistenceUser(consumer.getUser().getUsername())) {
				consumer.getUser().setRoles(Arrays.asList(
						this.roleRepository.findRoleByNameParam(USER)));
				
				String pass = consumer.getUser().getPassword();
				consumer.getUser().setPassword(passwordEncoder().encode(pass));
				
				
				this.userRepository.save(consumer.getUser());
				this.enderecoRepository.save(consumer.getEndereco());
				Consumer k = this.consumerRepository.save(consumer);
				if (k != null) {
					return true;
				}else {
					return false;
				}
			}else {
				return false;
			}
			
		}
		return false;
	}
	public boolean createShopKeeper(Shopkeeper keeper) {
		if(keeper != null) {
			
			if(!this.serviceValidator.checkExistenceUser(keeper.getUser().getUsername())) {
				this.userRepository.save(keeper.getUser());
				Shopkeeper k = this.shopKrepository.save(keeper);
				if (k != null) {
					return true;
				}else {
					return false;
				}
			}else {
				return false;
			}
			
		}
		return false;
	}

}
