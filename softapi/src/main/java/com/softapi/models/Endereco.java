package com.softapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="endereco")
public class Endereco {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	
	private String rua;
	
	private String bairro;
	
	private String cidade;
	
	private String cep;
	public Endereco() {}
	
	public Endereco(String rua,String bairro,String cidade,String cep) {
		setRua(rua);
		setBairro(bairro);
		setCidade(cidade);
		setCep(cep);

	}
	
	public void setRua(String rua) {
		this.rua=rua;
	}
	public String getRua() {
		return this.rua;
	}
	public void setBairro(String bairro) {
		this.bairro=bairro;
	}
	public String getBairro() {
		return this.bairro;
	}
	
	
	public void setCep(String cep) {
		this.cep=cep;
	}
	
	public String getCep() {
		return this.cep;
	}
	public void setCidade(String cidade) {
		this.cidade=cidade;
	}
	public String getCidade(String cidade) {
		return this.cidade;
	}
	
}
