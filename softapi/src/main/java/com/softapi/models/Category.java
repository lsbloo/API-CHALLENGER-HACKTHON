package com.softapi.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Category implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private Integer id;
	
	private String type_category;
	
	
	private String codigo;
	
	
	public void setId(Integer id) {
		this.id=id;
	}
	
	public Integer getId() {
		return this.id=id;
	}
	
	public void setTypeCategory(String type_category) {
		this.type_category=type_category;
	}
	public String getTypeCategory() {
		return this.type_category;
	}
	
	public void setCodigo(String codigo) {
		this.codigo=codigo;
	}
	public String getCodigo() {
		return this.codigo;
	}
	public Category() {}
	
	public Category(String type_category, String codigo) {
		setTypeCategory(type_category);
		setCodigo(codigo);
	}
	

}
