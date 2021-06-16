package org.test.chatbotclient.model;

public class WebhookMessage {
	
	public String id;
	public String resource;
	public String createdBy;
	public WebhookDataObject data;
	
	
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public WebhookDataObject getData() {
		return data;
	}
	public void setData(WebhookDataObject data) {
		this.data = data;
	}
	
	public String getResource() {
		return resource;
	}
	public void setResource(String resource) {
		this.resource = resource;
	}
	
	@Override
	public String toString() {
		return "WebhookMessage [id=" + id + ", resource=" + resource + ", createdBy=" + createdBy + ", data=" + data
				+ "]";
	}

	 
}
