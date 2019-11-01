package com.softapi.models;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;


@Entity
@Table(name="product")
public class Product implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private Integer id;
	
	private String preco;
	
	private String codigo;
	
	private Integer quantity;
	
	private String nome;
	
	@ManyToMany
	@JoinTable(name="category_products", joinColumns= {@JoinColumn(name="category_id", referencedColumnName="id")},
	inverseJoinColumns= {@JoinColumn(name="product_id", referencedColumnName="id")})
	private Collection<Category> categorys;
	
	public Product() {}
	
	public Product(String nome,String preco,String codigo,Integer quantity,List<Category> category) {
		setNome(nome);
		setPreco(preco);
		setCodigo(codigo);
		setQuantity(quantity);
		setCategory(category);
		
	}
	
	public void setId(Integer id) {
		this.id=id;
	}
	public Integer getId() {
		return this.id=id;
	}
	
	public void setPreco(String preco) {
		this.preco = preco;
	}
	public String getPreco() {
		return this.preco;
	}
	public void setCodigo(String codigo) {
		this.codigo=codigo;
	}
	public String getCodigo() {
		return this.codigo;
	}
	
	public void setQuantity(Integer qnt) {
		this.quantity=qnt;
	}
	
	public Integer getQuantity() {
		return this.quantity;
	}
	
	public void setCategory(List<Category> category) {
		this.categorys=category;
	}
	
	public List<Category> getCategory() {
		return (List<Category>) this.categorys;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
