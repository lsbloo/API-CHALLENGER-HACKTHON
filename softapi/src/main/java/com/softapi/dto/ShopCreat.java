package com.softapi.dto;

// DTO SHOP CREATED;
public class ShopCreat {

	
	private boolean status;
	
	private String description;
	
	public ShopCreat(boolean status,String description) {
		this.setStatus(status);
		this.setDescription(description);
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
