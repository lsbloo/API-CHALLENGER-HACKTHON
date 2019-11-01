package com.softapi.models;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;
import com.softapi.models.User;


@Entity
@Table(name="consumer")
public class Consumer {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	private String nome;
	
	private String email;
	
	
	@OneToOne
	private User user;
	
	
	
	@OneToOne
	private Endereco endereco;
	
	public void setId(Integer id) {
		this.id=id;
	}
	
	public Consumer(String email,Endereco endereco) {
		setEmail(email);
		setEndereco(endereco);
		
	}
	
	public void setNome(String nome) {
		this.nome=nome;
	}
	
	
	public String getNome() {
		return this.nome;
	}
	public void setEmail(String email) {
		this.email=email;
	}
	
	public String getEmail() {
		return this.email;
	}
	public Endereco getEndereco() {
		return this.endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco=endereco;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
