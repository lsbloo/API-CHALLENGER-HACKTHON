package com.softapi.models;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;


import org.springframework.security.core.GrantedAuthority;

@Entity
public class Role implements GrantedAuthority{
private String  name;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="id")
	private long id;
	
	/**
	 * Default COnstructor;
	 * @param param
	 */
	public Role(String param) {
		setName(param);
	}
	
	
	@ManyToMany
	@JoinTable(name="roles_privilege" , joinColumns= {@JoinColumn(name="role_id", referencedColumnName="id")},
	inverseJoinColumns= {@JoinColumn(name="privilege_id" , referencedColumnName="id")})
	private Collection<Privilege> privileges;
	

	
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return name;
	}

	/**
	 * Default Constructor Entity
	 */
	public Role() {}
	public Collection<Privilege> getPrivileges() {
		return privileges;
	}


	public void setPrivileges(Collection<Privilege> privileges) {
		this.privileges = privileges;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


}
