package com.softapi.dto;

import com.softapi.models.Consumer;

public class ConsumerCreate {
	
	private boolean status;
	
	private String description;
	
	private Consumer consumer;

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

	public Consumer getConsumer() {
		return consumer;
	}

	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
	}
	
	

}
