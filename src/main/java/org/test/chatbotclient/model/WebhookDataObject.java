package org.test.chatbotclient.model;

public class WebhookDataObject {
	public String id;
	public String roomId;
	public String personId;
	public String creatorId;
	
	public String getCreatorId() {
		return creatorId;
	}
	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	@Override
	public String toString() {
		return "WebhookDataObject [id=" + id + ", roomId=" + roomId + ", personId=" + personId + ", creatorId="
				+ creatorId + "]";
	}
 
}
