package com.softapi.models;

import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.OneToOne;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import com.softapi.models.User;


@Entity
@Table(name="shopkeeper")
public class Shopkeeper {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@OneToOne
	private User user;
	

	public void setUser(User user) {
		this.user=user;
	}
	
	public User getUser() {
		return this.user;
	}
	
	@ManyToMany
	@JoinTable(name="shops_shopkeeper", joinColumns= {@JoinColumn(name="shopkeeper_id", referencedColumnName="id")},
	inverseJoinColumns= {@JoinColumn(name="shops_id", referencedColumnName="id")})
	private List<Shop> shops;
	
	public Shopkeeper() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
