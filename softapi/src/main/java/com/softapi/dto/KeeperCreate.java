package com.softapi.dto;

import com.softapi.models.User;

public class KeeperCreate {

	
	private boolean status;
	
	private String description;

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
	
	public User user;
	
}
