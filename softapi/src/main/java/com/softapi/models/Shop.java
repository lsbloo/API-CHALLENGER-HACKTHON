package com.softapi.models;

import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.OneToOne;



@Entity
@Table(name="shop")
public class Shop {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	private String nome_fantasia;
	
	private String cnpj;
	
	private String telefone;
	
	@OneToOne
	private Endereco endereco;
	
	@OneToOne
	private Shopkeeper keeper;
	
	
	@ManyToMany
	@JoinTable(name="shops_products", joinColumns= {@JoinColumn(name="shop_id", referencedColumnName="id")},
	inverseJoinColumns= {@JoinColumn(name="product_id", referencedColumnName="id")})
	private Collection<Product> products;
	
	
	public void setId(Integer id) {
		this.id=id;
	}
	
	
	public Integer getId() {
		return this.id;
	}
	/**
	 * DefaultConstructor;
	 */
	public Shop() {}
	
	public Shop(String nome_fantasia,String cnpj,String telefone, Endereco endereco,List<Product> products) {
		setNome_fantasia(nome_fantasia);
		setCnpj(cnpj);
		setTelefone(telefone);
		setEndereco(endereco);
		setProducts(products);
	}
	
	public void setEndereco(Endereco endereco) {
		this.endereco=endereco;
	}
	
	public Endereco getEndereco() {
		return this.endereco;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj=cnpj;
	}
	public String getCnpj() {
		return this.cnpj;
	}
	
	public void setNome_fantasia(String nome_fantasia) {
		this.nome_fantasia=nome_fantasia;
	}
	public String getNome_fantasia() {
		return this.nome_fantasia;
	}
	public void setTelefone(String telefone) {
		this.telefone=telefone;
	}
	
	public String getTelefone() {
		return this.telefone;
	}
	
	public void setProducts(List<Product> products) {
		this.products=products;
	}
	public List<Product> getProducts(){
		return (List<Product>) this.products;
	}


	public Shopkeeper getKeeper() {
		return keeper;
	}


	public void setKeeper(Shopkeeper keeper) {
		this.keeper = keeper;
	}
}
